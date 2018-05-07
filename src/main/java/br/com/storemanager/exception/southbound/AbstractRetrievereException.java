package br.com.storemanager.exception.southbound;

import java.util.NoSuchElementException;

public abstract class AbstractRetrievereException extends NoSuchElementException {

    public AbstractRetrievereException(final String message) {
        super("[RETRIEVE EXCEPTION] " + message);
    }
}
