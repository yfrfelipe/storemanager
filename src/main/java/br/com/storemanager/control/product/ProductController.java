package br.com.storemanager.control.product;

import br.com.storemanager.control.validator.ProductValidator;
import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.dto.product.ProductPageDTO;
import br.com.storemanager.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(value = "storemanager", description = "Product Operations.")
public class ProductController implements ProductWebService {
    private static final Logger LOG = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productServiceImpl;

    @PostConstruct
    public void init() {
        LOG.info("Product Controller initialized with success!");
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create a given product.")
    @Override
    public void post(@RequestBody final ProductDTO product) {
        ProductValidator.validateProductDto(product);

        productServiceImpl.create(product);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Retrieve a product from a given ID.")
    @Override
    @ResponseBody
    public ProductDTO get(@PathVariable final Integer id) {
        return productServiceImpl.retrieve(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update a given product based on an existing ID.")
    @Override
    public void put(@PathVariable final Integer id, @RequestBody final ProductDTO product) {
        ProductValidator.validateId(id);
        ProductValidator.validateProductDto(product);

        productServiceImpl.update(id, product);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Delete a given product based on a given ID.")
    @Override
    public void delete(@PathVariable final Integer id) {
        ProductValidator.validateId(id);

        productServiceImpl.delete(id);
    }

    @PutMapping(path = "/down")
    @ApiOperation(value = "Evaluate a stock down for a listByQuantity of products.")
    @Override
    public void stockDown(@RequestBody final Map<Integer, Integer> productIdByQuantity) {
        productServiceImpl.productDown(productIdByQuantity);
    }

    @GetMapping(path = "/listByQuantity")
    @ApiOperation(value = "List a given quantity of products.")
    public ProductPageDTO listByQuantity(@RequestParam final Integer quantity) {
        return productServiceImpl.listProducts(quantity);
    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping Product Controller.");
    }
}
