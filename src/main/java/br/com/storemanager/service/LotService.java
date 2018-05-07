package br.com.storemanager.service;

import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.exception.southbound.lot.LotCreateException;
import br.com.storemanager.exception.southbound.lot.LotDeleteException;
import br.com.storemanager.exception.southbound.lot.LotNotFoundException;
import br.com.storemanager.exception.southbound.lot.LotUpdateException;

public interface LotService extends AbstractService<
        LotDTO,
        LotCreateException,
        LotUpdateException,
        LotNotFoundException,
        LotDeleteException> {
}
