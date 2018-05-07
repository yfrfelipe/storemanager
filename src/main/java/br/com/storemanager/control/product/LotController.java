package br.com.storemanager.control.product;

import br.com.storemanager.control.validator.LotValidator;
import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.service.LotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/lot")
@Api(value = "storemanager", description = "Lot Operations")
public class LotController implements LotWebService {
    private static final Logger LOG = LogManager.getLogger(LotController.class);

    @Autowired
    private LotService lotServiceImpl;

    public void init() {
        LOG.info("Lot Controller initialized with success!");
    }

    @PostMapping(path = "/")
    @ApiOperation(value = "Create a given lot containing a list of products.")
    @Override
    public void post(@RequestBody final LotDTO lot) {
        LotValidator.validateLot(lot);

        lotServiceImpl.create(lot);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Retrieve a given lot from a given ID.")
    @Override
    @ResponseBody
    public LotDTO get(@PathVariable final Integer id) {
        LotValidator.validateId(id);

        return lotServiceImpl.retrieve(id);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Update a given lot based on an existing ID.")
    @Override
    public void put(@PathVariable final Integer id, final @RequestBody LotDTO modelDTO) {
        LotValidator.validateId(id);
        LotValidator.validateLot(modelDTO);

        lotServiceImpl.update(id, modelDTO);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Delete a given lot based on a given ID.")
    @Override
    public void delete(@PathVariable final Integer id) {
        LotValidator.validateId(id);

        lotServiceImpl.delete(id);
    }

    @Override
    public void close() throws Exception {
        LOG.info("Stopping Lot Controller ");
    }
}
