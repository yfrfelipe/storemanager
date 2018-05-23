package br.com.storemanager.exception.southbound.reservation;

import br.com.storemanager.exception.southbound.AbstractUpdateException;

public class ReservationUpdateException extends AbstractUpdateException {

    public ReservationUpdateException(final String message) {
        super(message);
    }
}
