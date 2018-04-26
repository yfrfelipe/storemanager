package br.com.storemanager.service;

import br.com.storemanager.model.AbstractDTO;
import java.util.UUID;

public interface AbstractService<T extends AbstractDTO> {

    void create(T entityDTO);

    void update(T entityDTO);

    void delete(UUID id);
}
