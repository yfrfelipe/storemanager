package br.com.storemanager.exception.southbound.reservation;

import br.com.storemanager.exception.southbound.AbstractDeleteException;

public class ReservationDeleteException extends AbstractDeleteException {

    public ReservationDeleteException(String message) {
        super(message);
    }
}
