package br.com.storemanager.service;

import br.com.storemanager.exception.southbound.reservation.ReservationCreateException;
import br.com.storemanager.exception.southbound.reservation.ReservationDeleteException;
import br.com.storemanager.exception.southbound.reservation.ReservationUpdateException;
import java.util.UUID;

public interface ReservationService {

    void createReservation(UUID transactionID) throws ReservationCreateException;

    void cancelReservation(UUID transactionID) throws ReservationUpdateException;

    void finalizeReservation(UUID transactionID) throws ReservationDeleteException;
}
