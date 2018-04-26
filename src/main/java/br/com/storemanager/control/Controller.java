package br.com.storemanager.control;

import br.com.storemanager.model.AbstractDTO;
import java.util.UUID;

/**
 * This service is used to manage HTTP requests.
 */
public interface Controller<T extends AbstractDTO> {

    /**
     * This method is responsible to receive a DTO to be created.
     */
    void doPost(T entityDTO);

    /**
     * This method is responsble to retrieve a given data.
     */
    void doGet(UUID id);

    void doPut(T entityDTO);

    void doDelete(String userId, String id);
}
