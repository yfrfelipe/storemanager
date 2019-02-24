package br.com.storemanager.control.reservation;

import br.com.storemanager.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@Api(value = "storemanager", description = "Product reservation operations.")
public class ReservationControl {
    private static final Logger LOG = LogManager.getLogger(ReservationControl.class);

    @Autowired
    private ReservationService reservationService;

    @PostConstruct
    public void init() {
        LOG.info("Reservation controller initialized with success.");
    }

    @PutMapping(path = "/reserve")
    @ApiOperation(value = "Create a reservation based on a given transaction ID.")
    public void create(@RequestParam final UUID transactionID,
                       @RequestParam final Long reserveTimeout,
                       @RequestBody final Map<Integer, Integer> productByQuantity) {

        //TODO: Validate if transaction ID isn't null or empty
        reservationService.createReservation(transactionID, productByQuantity, reserveTimeout);
    }

    @PutMapping(path = "/cancel")
    @ApiOperation(value = "Cancel a reservation based on a given transaction ID.")
    public void cancel(@RequestParam final UUID transactionID) {
        reservationService.cancelReservation(transactionID);
    }

    @PutMapping(path = "/finalize")
    @ApiOperation(value = "Finalize a reservation based on a given transaction ID.")
    @ResponseBody
    public UUID finalizeReservation(@RequestBody final UUID transactionID) {
        return reservationService.finalizeReservation(transactionID);
    }
}
