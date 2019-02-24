package br.com.storemanager.control.validator;

import br.com.storemanager.exception.southbound.reservation.ReservationDeleteException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReservationAdvice extends AbstractValidator {
    private static final Logger LOG = LogManager.getLogger(ReservationAdvice.class);

    @ResponseBody
    @ExceptionHandler(ReservationDeleteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String reservationNotFoundHandler(final ReservationDeleteException e) {
        LOG.error(e);
        return e.getMessage();
    }
}
