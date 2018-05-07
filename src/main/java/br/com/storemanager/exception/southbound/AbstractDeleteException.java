package br.com.storemanager.exception.southbound;

public abstract class AbstractDeleteException extends RuntimeException {

    public AbstractDeleteException(final String message) {
        super("[DELETE EXCEPTION] " + message);
    }
}
