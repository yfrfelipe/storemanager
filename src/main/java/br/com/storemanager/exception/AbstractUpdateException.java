package br.com.storemanager.exception;

public abstract class AbstractUpdateException extends RuntimeException {

    public AbstractUpdateException(final String message) {
        super("[UPDATE EXCEPTION] " + message);
    }
}
