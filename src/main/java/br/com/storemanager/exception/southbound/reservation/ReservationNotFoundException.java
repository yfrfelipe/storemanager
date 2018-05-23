package br.com.storemanager.exception.southbound.reservation;

import br.com.storemanager.exception.southbound.AbstractRetrievereException;

public class ReservationNotFoundException extends AbstractRetrievereException {

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
