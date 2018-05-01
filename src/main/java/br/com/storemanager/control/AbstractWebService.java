package br.com.storemanager.control;

import br.com.storemanager.dto.AbstractDTO;

/**
 * This service is used to manage HTTP requests.
 */
public interface AbstractWebService<T extends AbstractDTO> {

    /**
     * This method is responsible to receive a DTO to be created.
     */
    void doPost(T modelDTO);

    /**
     * This method is responsble to retrieve a given data.
     */
    T doGet(Long id);

    void doPut(T modelDTO);

    void doDelete(T modelDTO);
}
