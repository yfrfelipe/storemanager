package br.com.storemanager.service;

import br.com.storemanager.dto.BarcodeDTO;
import br.com.storemanager.dto.ProductDTO;
import br.com.storemanager.exception.ProductCreateException;
import br.com.storemanager.exception.ProductDeleteException;
import br.com.storemanager.exception.ProductNotFoundException;
import br.com.storemanager.exception.ProductUpdateException;
import br.com.storemanager.model.product.Barcode;
import br.com.storemanager.model.product.Product;
import br.com.storemanager.persistence.ProductRepository;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        modelMapper.createTypeMap(Product.class, ProductDTO.class);
        modelMapper.createTypeMap(Barcode.class, BarcodeDTO.class);
        modelMapper.createTypeMap(ProductDTO.class, Product.class);
        modelMapper.createTypeMap(BarcodeDTO.class, Barcode.class);
        LOG.info("ProductService initialized with success. Product repository instance: {}", productRepository);
    }

    @Override
    public void create(ProductDTO entityDTO) throws ProductCreateException {
        final Product product = modelMapper.map(entityDTO, Product.class);
        final Barcode barcode = modelMapper.map(entityDTO.getBarcodeDTO(), Barcode.class);

        product.setBarcode(barcode);
        productRepository.save(product);
    }

    @Override
    public ProductDTO retrieve(final Integer id) throws ProductNotFoundException {
        final Optional<Product> optional = productRepository.findById(id);
        final Product product = optional
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));
        LOG.debug("Product retrieved: {}", product.getName());
        final ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        final BarcodeDTO barcodeDTO = modelMapper.map(product.getBarcode(), BarcodeDTO.class);

        productDTO.setBarcodeDTO(barcodeDTO);
        return productDTO;
    }

    @Override
    public void update(ProductDTO entityDTO) throws ProductUpdateException {

    }

    @Override
    public void delete(Integer id) throws ProductDeleteException {

    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping Product Service.");
    }
}
