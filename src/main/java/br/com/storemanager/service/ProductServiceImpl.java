package br.com.storemanager.service;

import br.com.storemanager.converter.ProductConverter;
import br.com.storemanager.dto.ProductDTO;
import br.com.storemanager.exception.ProductCreateException;
import br.com.storemanager.exception.ProductDeleteException;
import br.com.storemanager.exception.ProductNotFoundException;
import br.com.storemanager.exception.ProductUpdateException;
import br.com.storemanager.model.Product;
import br.com.storemanager.persistence.ProductRepository;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        LOG.info("ProductService initialized with success. Product repository instance: {}", productRepository);
    }

    @Override
    public void create(ProductDTO entityDTO) throws ProductCreateException {
        LOG.info("Person received: {}", entityDTO);
        final Product product = ProductConverter.fromProductDTOToProduct(entityDTO);
        productRepository.save(product);
    }

    @Override
    public ProductDTO retrieve(final Long id) throws ProductNotFoundException {
        ProductDTO result;
        final Optional<Product> optional = productRepository.findById(id);
        final Product product = optional
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));
        LOG.debug("Product retrieved: {}", product.getName());
        final ProductDTO productDTO = ProductConverter.fromProductToProductDTO(product);
        result = productDTO;
        return result;
    }

    @Override
    public void update(ProductDTO entityDTO) throws ProductUpdateException {

    }

    @Override
    public void delete(Long id) throws ProductDeleteException {

    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping Product Service.");
    }
}
