package br.com.storemanager.service;

import br.com.storemanager.exception.southbound.reservation.ReservationCreateException;
import br.com.storemanager.exception.southbound.reservation.ReservationDeleteException;
import br.com.storemanager.exception.southbound.reservation.ReservationUpdateException;
import br.com.storemanager.model.reservation.ProductByQuantity;
import br.com.storemanager.model.reservation.Reservation;
import br.com.storemanager.persistence.ReservationRepository;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ReservationServiceImpl implements ReservationService {
    private static final Logger LOG = LogManager.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ProductService productService;

    @Override
    public synchronized void createReservation(final UUID transactionID,
                                               final Map<Integer, Integer> productByQuantity,
                                               final Long reservationTime) throws ReservationCreateException {
        final Long currentTime = System.currentTimeMillis();
        final Reservation reservation = new Reservation();
        final Set<ProductByQuantity> productByQuantities = Sets.newHashSet();

        for (Integer productId : productByQuantity.keySet()) {
            final ProductByQuantity productByQuantityEntity = new ProductByQuantity();

            productByQuantityEntity.setProductId(productId);
            productByQuantityEntity.setQuantity(productByQuantity.get(productId));
            productByQuantities.add(productByQuantityEntity);
        }
        reservation.setReservationID(transactionID);
        reservation.setProductByQuantity(productByQuantities);
        reservation.setTimestamp(currentTime);
        reservation.setReserveTime(currentTime + reservationTime);
        reservation.setIsActive(true);

        productService.productDown(productByQuantity);
        reservationRepository.save(reservation);
    }

    @Transactional
    @Override
    public synchronized void cancelReservation(final UUID transactionID) throws ReservationUpdateException {
        if (!reservationRepository.existsById(transactionID)) {
            LOG.warn("Transaction with ID {} does not exist.");
            throw new ReservationUpdateException(
                    String.format("Could cancel the reservation with ID %s. Reservation not found.",
                            transactionID.toString()));
        }

        final Reservation reservation = reservationRepository.findById(transactionID).get();
        productService.putBackToStock(toMap(reservation.getProductByQuantity()));
        LOG.debug("Removing reservation with ID: {}", reservation.getReservationID());
        reservation.setIsActive(false);
        reservationRepository.save(reservation);
    }

    @Override
    public synchronized UUID finalizeReservation(final UUID transactionID) throws ReservationDeleteException {
        if (reservationRepository.existsById(transactionID)) {
            LOG.info("Finalizing reservation with ID: {}", transactionID);
            reservationRepository.deleteById(transactionID);
        } else {
            throw new ReservationDeleteException(transactionID.toString());
        }
        return transactionID;
    }

    @Override
    public synchronized Set<Reservation> retrieveExpiredReservation() {
        final Set<Reservation> expired = Sets.newHashSet();
        expired.addAll(reservationRepository.retrieveExpiredReservations(System.currentTimeMillis()));
        LOG.debug("Expired reservations: {}", expired);
        return expired;
    }

    private Map<Integer, Integer> toMap(final Set<ProductByQuantity> productByQuantitySet) {
        Map<Integer, Integer> result = Maps.newHashMap();

        for (ProductByQuantity productByQuantity : productByQuantitySet) {
            result.put(productByQuantity.getProductId(), productByQuantity.getQuantity());
        }
        return result;
    }
}
