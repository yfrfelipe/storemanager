package br.com.storemanager.exception.southbound.Product;

import br.com.storemanager.exception.southbound.AbstractRetrievereException;

public class ProductNotFoundException extends AbstractRetrievereException {

    public ProductNotFoundException(final String message) {
        super(message);
    }
}
