package br.com.storemanager.service;

import br.com.storemanager.exception.southbound.reservation.ReservationCreateException;
import br.com.storemanager.exception.southbound.reservation.ReservationDeleteException;
import br.com.storemanager.exception.southbound.reservation.ReservationUpdateException;
import br.com.storemanager.model.reservation.Reservation;
import br.com.storemanager.persistence.ReservationRepository;
import com.google.common.collect.Maps;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ProductService productService;

    @Override
    public void createReservation(final UUID transactionID) throws ReservationCreateException {
        final Reservation reservation = new Reservation();
        reservation.setReservationID(transactionID);
        reservation.setProductByQuantity(Maps.newHashMap());
        reservation.setTimestamp(System.currentTimeMillis());

        reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservation(final UUID transactionID) throws ReservationUpdateException {
        final Optional<Reservation> optional = reservationRepository.findById(transactionID);
        if (!optional.isPresent()) {
            throw new ReservationUpdateException(
                    String.format("Could cancel the reservation with ID %s. Reservation not found.",
                            transactionID.toString()));
        }

        final Reservation reservation = optional.get();
        productService.putBackToStock(reservation.getProductByQuantity());
    }

    @Override
    public void finalizeReservation(final UUID transactionID) throws ReservationDeleteException {
        reservationRepository.deleteById(transactionID);
    }

    //TODO: Implement the reservation timeout handler.
}
