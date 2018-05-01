package br.com.storemanager.service;

import br.com.storemanager.dto.ProductDTO;
import br.com.storemanager.exception.ProductCreateException;
import br.com.storemanager.exception.ProductDeleteException;
import br.com.storemanager.exception.ProductNotFoundException;
import br.com.storemanager.exception.ProductUpdateException;

public interface ProductService extends AbstractService<
        ProductDTO,
        ProductCreateException,
        ProductUpdateException,
        ProductNotFoundException,
        ProductDeleteException>, AutoCloseable {
}
