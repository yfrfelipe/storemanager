package br.com.storemanager.service;

import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.exception.southbound.lot.LotCreateException;
import br.com.storemanager.exception.southbound.lot.LotDeleteException;
import br.com.storemanager.exception.southbound.lot.LotNotFoundException;
import br.com.storemanager.exception.southbound.lot.LotUpdateException;
import br.com.storemanager.model.product.Lot;
import br.com.storemanager.persistence.LotRepository;
import br.com.storemanager.service.convertor.ConvertService;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotServiceImpl implements LotService {
    private static final Logger LOG = LogManager.getLogger(LotServiceImpl.class);

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private ConvertService<Lot, LotDTO> lotConvert;

    @PostConstruct
    public void init() {
        LOG.info("Lot Service initialized with success.");
    }

    @Override
    public void create(LotDTO entityDTO) throws LotCreateException {

        final Lot lot = lotConvert.fromDto(entityDTO);
        lotRepository.save(lot);
    }

    @Override
    public LotDTO retrieve(Integer id) throws LotNotFoundException {
        isExistingLot(id);

        final Optional<Lot> optional = lotRepository.findById(id);
        final Lot lot = optional.get();

        return lotConvert.toDto(lot);
    }

    @Override
    public void update(Integer id, LotDTO entityDTO) throws LotUpdateException {
        isExistingLot(id);

        final Lot lotToUpdate = lotConvert.fromDto(entityDTO);
        lotToUpdate.setId(id);
        lotRepository.save(lotToUpdate);
    }

    @Override
    public void delete(Integer id) throws LotDeleteException {
        isExistingLot(id);

        lotRepository.deleteById(id);
    }

    private void isExistingLot(final Integer id) throws LotNotFoundException {
        if (!lotRepository.existsById(id)) {
            throw new LotNotFoundException("Lot with ID " + id + " does not exist.");
        }
    }

    @Override
    public void close() {
        LOG.info("Stopping Lot Service.");
    }
}
