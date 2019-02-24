package br.com.storemanager.service;

import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.dto.product.LotPageDTO;
import br.com.storemanager.exception.southbound.lot.LotCreateException;
import br.com.storemanager.exception.southbound.lot.LotDeleteException;
import br.com.storemanager.exception.southbound.lot.LotNotFoundException;
import br.com.storemanager.exception.southbound.lot.LotUpdateException;
import br.com.storemanager.model.product.Lot;
import br.com.storemanager.persistence.LotRepository;
import br.com.storemanager.service.convertor.ConvertService;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LotServiceImpl implements LotService {
    private static final Logger LOG = LogManager.getLogger(LotServiceImpl.class);

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private ConvertService<Lot, LotDTO> lotConvertor;

    @PostConstruct
    public void init() {
        LOG.info("Lot Service initialized with success.");
    }

    @Override
    public void create(LotDTO entityDTO) throws LotCreateException {

        final Lot lot = lotConvertor.fromDto(entityDTO);
        lotRepository.save(lot);
    }

    @Override
    public LotDTO retrieve(Integer id) throws LotNotFoundException {
        isExistingLot(id);

        final Optional<Lot> optional = lotRepository.findById(id);
        final Lot lot = optional.get();

        return lotConvertor.toDto(lot);
    }

    @Override
    public void update(Integer id, LotDTO entityDTO) throws LotUpdateException {
        isExistingLot(id);

        final Lot lotToUpdate = lotConvertor.fromDto(entityDTO);
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

    @Override
    public LotPageDTO listLots(Integer quantity) {
        final Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "providerId"));
        final Pageable pageable = PageRequest.of(0, quantity, sort);
        final Page<Lot> page = lotRepository.findAll(pageable);

        final LotPageDTO lotPageDTO = new LotPageDTO();

        final List<LotDTO> lots = Lists.newArrayList();

        for (Lot lot : page.getContent()) {
            lots.add(lotConvertor.toDto(lot));
        }

        lotPageDTO.setContent(lots);
        lotPageDTO.setTotalElements(page.getTotalElements());
        lotPageDTO.setTotalPages(page.getTotalPages());
        return lotPageDTO;
    }
}
