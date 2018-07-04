package br.com.storemanager.service;

import br.com.storemanager.exception.southbound.reservation.ReservationCreateException;
import br.com.storemanager.exception.southbound.reservation.ReservationDeleteException;
import br.com.storemanager.exception.southbound.reservation.ReservationUpdateException;
import br.com.storemanager.model.reservation.Reservation;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface ReservationService {

    void createReservation(UUID transactionID,
                           Map<Integer,Integer> productByQuantity,
                           Long reservationTime) throws ReservationCreateException;

    void cancelReservation(UUID transactionID) throws ReservationUpdateException;

    void finalizeReservation(UUID transactionID) throws ReservationDeleteException;

    Set<Reservation> retrieveExpiredReservation();
}
