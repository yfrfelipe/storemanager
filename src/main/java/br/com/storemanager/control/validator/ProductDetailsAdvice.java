package br.com.storemanager.control.validator;

import br.com.storemanager.exception.southbound.Product.ProductDetailsNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class ProductDetailsAdvice extends AbstractValidator {
    private static final Logger LOG = LogManager.getLogger(ProductDetailsAdvice.class);

    @ResponseBody
    @ExceptionHandler(ProductDetailsNotFoundException.class)
    public String productDetailsNotFoundHandler(final ProductDetailsNotFoundException e) {
        LOG.error(e);
        return e.getMessage();
    }
}
