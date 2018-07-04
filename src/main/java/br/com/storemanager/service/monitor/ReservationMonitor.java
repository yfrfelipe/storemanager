package br.com.storemanager.service.monitor;

import br.com.storemanager.exception.southbound.reservation.ReservationUpdateException;
import br.com.storemanager.model.reservation.Reservation;
import br.com.storemanager.service.ReservationService;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ReservationMonitor implements ReservationMonitorService {
    private static final Logger LOG = LogManager.getLogger(ReservationMonitor.class);

    private Timer timer;

    @Autowired
    private ReservationService reservationService;

    @PostConstruct
    public void init() {
        LOG.info("\n######Starting RESERVATION THREAD!");
        this.timer = new Timer(true);

        timer.scheduleAtFixedRate(new TimerWorker(), 10000, 10000);

        LOG.info("Reservation monitor started with success.");
    }

    private class TimerWorker extends TimerTask {

        @Override
        public void run() {
            LOG.info("Verifying reservations.");
            final Set<Reservation> reservations = reservationService.retrieveExpiredReservation();
            for (Reservation reservation : reservations) {
                try {
                    reservationService.cancelReservation(reservation.getReservationID());
                    LOG.info("Reservation with ID {} cancelled due to expiration time.",
                            reservation.getReservationID());
                } catch (ReservationUpdateException e) {
                    LOG.error(e);
                }
            }
        }
    }

    @PreDestroy
    public void stop() {
        LOG.info("Stopping reservation monitor.");
        timer.cancel();
    }
}
