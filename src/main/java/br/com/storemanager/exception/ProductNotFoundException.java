package br.com.storemanager.exception;

public class ProductNotFoundException extends AbstractRetrievereException {

    public ProductNotFoundException(final String message) {
        super(message);
    }
}
