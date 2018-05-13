package br.com.storemanager.exception.southbound.Product;

import br.com.storemanager.exception.southbound.AbstractRetrievereException;

public class ProductDetailsNotFoundException extends AbstractRetrievereException {

    public ProductDetailsNotFoundException(final String message) {
        super(message);
    }
}
