package br.com.storemanager.service;

import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.exception.southbound.Product.ProductCreateException;
import br.com.storemanager.exception.southbound.Product.ProductDeleteException;
import br.com.storemanager.exception.southbound.Product.ProductNotFoundException;
import br.com.storemanager.exception.southbound.Product.ProductUpdateException;

public interface ProductService extends AbstractService<
        ProductDTO,
        ProductCreateException,
        ProductUpdateException,
        ProductNotFoundException,
        ProductDeleteException> {
}
