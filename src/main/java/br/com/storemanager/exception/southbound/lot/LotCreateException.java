package br.com.storemanager.exception.southbound.lot;

import br.com.storemanager.exception.southbound.AbstractCreateException;

public class LotCreateException extends AbstractCreateException {

    public LotCreateException(final String message) {
        super(message);
    }
}
