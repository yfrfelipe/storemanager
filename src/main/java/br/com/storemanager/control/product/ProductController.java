package br.com.storemanager.control.product;

import br.com.storemanager.dto.ProductDTO;
import br.com.storemanager.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(value = "storemanager", description = "Operations.")
public class ProductController implements ProductWebService {
    private static final Logger LOG = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productServiceImpl;

    @PostConstruct
    public void init() {
        LOG.info("Product Controller initialized with success! ProductService instance: {}", productServiceImpl);
    }

    @PostMapping(path = "/")
    @Override
    public void doPost(@RequestBody ProductDTO modelDTO) {
        productServiceImpl.create(modelDTO);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Search a product from a given ID.")
    @Override
    @ResponseBody
    public ProductDTO doGet(@PathVariable Integer id) {
        return productServiceImpl.retrieve(id);
    }

    @PutMapping(path = "/")
    @Override
    public void doPut(ProductDTO modelDTO) {

    }

    @DeleteMapping(path = "/")
    @Override
    public void doDelete(ProductDTO modelDTO) {

    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping down Product Controller.");
    }
}
