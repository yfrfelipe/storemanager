package br.com.storemanager.exception.southbound.Product;

import java.util.Set;

public class InsuficientQuantityException extends RuntimeException {

    private Set<Integer> productIds;

    public InsuficientQuantityException(final Set<Integer> productIds) {
        this.productIds = productIds;
    }

    @Override
    public String getMessage() {
        return String.format("Os seguinte produtos não possuem a quantidade desejada no estoque: %s.", productIds);
    }

}
