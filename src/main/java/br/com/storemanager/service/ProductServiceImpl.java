package br.com.storemanager.service;

import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.exception.southbound.Product.InsuficientQuantityException;
import br.com.storemanager.exception.southbound.Product.ProductCreateException;
import br.com.storemanager.exception.southbound.Product.ProductDeleteException;
import br.com.storemanager.exception.southbound.Product.ProductNotFoundException;
import br.com.storemanager.exception.southbound.Product.ProductUpdateException;
import br.com.storemanager.model.product.Product;
import br.com.storemanager.persistence.ProductRepository;
import br.com.storemanager.service.convertor.ConvertService;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.internal.guava.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConvertService<Product, ProductDTO> productConvertor;


    @PostConstruct
    public void init() {

        LOG.info("Product Service initialized with success.");
    }

    @Override
    public void create(final ProductDTO entityDTO) throws ProductCreateException {
        final Product product = productConvertor.fromDto(entityDTO);

        productRepository.save(product);
    }

    @Override
    public ProductDTO retrieve(final Integer id) throws ProductNotFoundException {
        isExistingProduct(id);

        final Optional<Product> optional = productRepository.findById(id);
        final Product product = optional.get();
        LOG.debug("product retrieved: {}", product.getName());

        return productConvertor.toDto(product);
    }

    @Override
    public void update(final Integer id, final ProductDTO entityDTO) throws ProductUpdateException {
        isExistingProduct(id);

        final Product productToUpdate = productConvertor.fromDto(entityDTO);
        productToUpdate.setId(id);
        productRepository.save(productToUpdate);
    }

    @Override
    public void delete(final Integer id) throws ProductDeleteException {
        isExistingProduct(id);

        productRepository.deleteById(id);
    }


    @Override
    public void productDown(final Map<Integer, Integer> productIdByQuantity) throws InsuficientQuantityException {
        final Iterable<Product> iterable = productRepository.findAllById(productIdByQuantity.keySet());
        final Set<Integer> productIdsWithInsuficientQuantity = Sets.newHashSet();
        final Set<Product> productsWithNewQuantity = Sets.newHashSetWithExpectedSize(productIdByQuantity.keySet().size());
        final Iterator<Product> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            final Product product = iterator.next();
            final Integer currentQuantity = product.getProductDetails().getQuantity();
            final Integer newQuantity = Math.subtractExact(currentQuantity, productIdByQuantity.get(product.getId()));
            if (newQuantity < 0) {
                productIdsWithInsuficientQuantity.add(product.getId());
            } else {
                product.getProductDetails().setQuantity(newQuantity);
                productsWithNewQuantity.add(product);
            }
        }

        if (!productIdsWithInsuficientQuantity.isEmpty()) {
            throw new InsuficientQuantityException(productIdsWithInsuficientQuantity);
        }

        productRepository.saveAll(productsWithNewQuantity);

    }

    private void isExistingProduct(final Integer id) throws ProductNotFoundException {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " does not exist.");
        }
    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping product Service.");
    }
}
