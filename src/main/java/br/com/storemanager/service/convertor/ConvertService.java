package br.com.storemanager.service.convertor;

import br.com.storemanager.dto.AbstractDTO;
import br.com.storemanager.model.AbstractEntity;

public interface ConvertService<E extends AbstractEntity, D extends AbstractDTO> {

    E fromDto(D dto);

    D toDto(E entity);
}
