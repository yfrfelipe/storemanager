package br.com.storemanager.exception.southbound.Product;

import br.com.storemanager.exception.southbound.AbstractCreateException;

public class ProductCreateException extends AbstractCreateException {

    public ProductCreateException(final String message) {
        super(message);
    }
}
