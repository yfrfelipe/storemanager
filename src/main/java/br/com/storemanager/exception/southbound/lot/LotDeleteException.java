package br.com.storemanager.exception.southbound.lot;

import br.com.storemanager.exception.southbound.AbstractDeleteException;

public class LotDeleteException extends AbstractDeleteException {

    public LotDeleteException(final String message) {
        super(message);
    }
}
