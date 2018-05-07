package br.com.storemanager.service;

import br.com.storemanager.dto.AbstractDTO;
import br.com.storemanager.exception.southbound.AbstractCreateException;
import br.com.storemanager.exception.southbound.AbstractDeleteException;
import br.com.storemanager.exception.southbound.AbstractRetrievereException;
import br.com.storemanager.exception.southbound.AbstractUpdateException;

public interface AbstractService<
        T extends AbstractDTO,
        C extends AbstractCreateException,
        U extends AbstractUpdateException,
        R extends AbstractRetrievereException,
        D extends AbstractDeleteException> extends AutoCloseable {

    void create(T entityDTO) throws C;

    T retrieve(Integer id) throws R;

    void update(Integer id, T entityDTO) throws U;

    void delete(Integer id) throws D;
}
