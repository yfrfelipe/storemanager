package br.com.storemanager.exception;

public abstract class AbstractDeleteException extends RuntimeException {

    public AbstractDeleteException(final String message) {
        super("[DELETE EXCEPTION] " + message);
    }
}
