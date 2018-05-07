package br.com.storemanager.exception.southbound.lot;

import br.com.storemanager.exception.southbound.AbstractRetrievereException;

public class LotNotFoundException extends AbstractRetrievereException {

    public LotNotFoundException(final String message) {
        super(message);
    }
}
