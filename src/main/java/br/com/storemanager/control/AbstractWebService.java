package br.com.storemanager.control;

import br.com.storemanager.model.AbstractDTO;
import java.util.Map;
import java.util.UUID;

/**
 * This service is used to manage HTTP requests.
 */
public interface AbstractWebService<T extends AbstractDTO> {

    /**
     * This method is responsible to receive a DTO to be created.
     */
    void doPost(Map<String, T> modelDTO);

    /**
     * This method is responsble to retrieve a given data.
     */
    void doGet(UUID id);

    void doPut(Map<String, T> modelDTO);

    void doDelete(Map<String, T> modelDTO);
}
