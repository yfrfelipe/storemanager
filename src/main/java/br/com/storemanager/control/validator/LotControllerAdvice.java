package br.com.storemanager.control.validator;

import br.com.storemanager.exception.northbound.lot.LotInvalidExcecption;
import br.com.storemanager.exception.southbound.lot.LotNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LotControllerAdvice {
    private static final Logger LOG = LogManager.getLogger(LotControllerAdvice.class);

    @ResponseBody
    @ExceptionHandler(LotNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String lotNotFoundExceptionHandler(final LotNotFoundException e) {
        LOG.error(e);
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(LotInvalidExcecption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String lotInvalidExceptionHandler(final LotInvalidExcecption e) {
        LOG.error(e);
        return e.getMessage();
    }
}
