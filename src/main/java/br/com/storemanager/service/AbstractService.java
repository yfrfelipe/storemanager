package br.com.storemanager.service;

import br.com.storemanager.dto.AbstractDTO;
import br.com.storemanager.exception.AbstractCreateException;
import br.com.storemanager.exception.AbstractDeleteException;
import br.com.storemanager.exception.AbstractRetrievereException;
import br.com.storemanager.exception.AbstractUpdateException;
import java.util.UUID;

public interface AbstractService<
        T extends AbstractDTO,
        C extends AbstractCreateException,
        U extends AbstractUpdateException,
        R extends AbstractRetrievereException,
        D extends AbstractDeleteException> {

    void create(T entityDTO) throws C;

    T retrieve(Long id) throws R;

    void update(T entityDTO) throws U;

    void delete(Long id) throws D;
}
