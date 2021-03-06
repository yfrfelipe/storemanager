package br.com.storemanager.control;

import br.com.storemanager.dto.AbstractDTO;
import br.com.storemanager.dto.AbstractPageDTO;
import java.util.List;

/**
 * This service is used to manage HTTP requests.
 */
public interface AbstractWebService<T extends AbstractDTO> extends AutoCloseable  {

    /**
     * This method is responsible to receive a DTO to be created.
     */
    void post(T modelDTO);

    /**
     * This method is responsble to retrieve a given data.
     */
    T get(Integer id);

    void put(Integer id, T modelDTO);

    void delete(Integer id);

    AbstractPageDTO<T> listProducts(Integer quantity);


}
