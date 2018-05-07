package br.com.storemanager.exception.southbound.lot;

import br.com.storemanager.exception.southbound.AbstractUpdateException;

public class LotUpdateException extends AbstractUpdateException {

    public LotUpdateException(final String message) {
        super(message);
    }
}
