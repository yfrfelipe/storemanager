package br.com.storemanager.exception;

public abstract class AbstractCreateException extends RuntimeException {

    public AbstractCreateException(final String message) {
        super("[CREATE EXCEPTION] " + message);
    }
}
