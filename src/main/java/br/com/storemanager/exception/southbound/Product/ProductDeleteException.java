package br.com.storemanager.exception.southbound.Product;

import br.com.storemanager.exception.southbound.AbstractDeleteException;

public class ProductDeleteException extends AbstractDeleteException {

    public ProductDeleteException(final String message) {
        super(message);
    }
}
