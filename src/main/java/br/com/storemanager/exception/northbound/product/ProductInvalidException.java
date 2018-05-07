package br.com.storemanager.exception.northbound.product;

import br.com.storemanager.exception.northbound.AbstractNorthBoundException;

public class ProductInvalidException extends AbstractNorthBoundException {

    public ProductInvalidException(final String message) {
        super(message);
    }
}
