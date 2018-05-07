package br.com.storemanager.exception.southbound.Product;

import br.com.storemanager.exception.southbound.AbstractUpdateException;

public class ProductUpdateException extends AbstractUpdateException {

    public ProductUpdateException(final String message) {
        super(message);
    }
}
