package br.com.storemanager.control.validator;

import br.com.storemanager.exception.northbound.IDInvalidException;
import br.com.storemanager.exception.northbound.product.ProductInvalidException;
import br.com.storemanager.exception.southbound.Product.ProductNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    private static final Logger LOG = LogManager.getLogger(ProductControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFoundExceptionHandler(final ProductNotFoundException e) {
        LOG.error(e);
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProductInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String productInvalidExceptionHandler(final ProductInvalidException e) {
        LOG.error(e);
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(IDInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidIDExceptionHandler(final IDInvalidException e) {
        LOG.error(e);
        return e.getMessage();
    }
}
