package br.com.storemanager.exception.southbound.reservation;

import br.com.storemanager.exception.southbound.AbstractCreateException;

public class ReservationCreateException extends AbstractCreateException {

    public ReservationCreateException(String message) {
        super(message);
    }
}
