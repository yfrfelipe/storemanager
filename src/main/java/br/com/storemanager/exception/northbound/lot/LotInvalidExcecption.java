package br.com.storemanager.exception.northbound.lot;


import br.com.storemanager.exception.northbound.AbstractNorthBoundException;

public class LotInvalidExcecption extends AbstractNorthBoundException {

    public LotInvalidExcecption(final String message) {
        super(message);
    }
}
