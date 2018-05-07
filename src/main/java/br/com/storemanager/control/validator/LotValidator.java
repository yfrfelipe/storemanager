package br.com.storemanager.control.validator;

import br.com.storemanager.dto.product.LotDTO;
import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.exception.northbound.lot.LotInvalidExcecption;
import java.util.Objects;

public class LotValidator extends AbstractValidator {

    private static final String INVALID_BARCODE_MESSAGE = "Código de barras inválido.";
    private static final String INVALID_PRODUCTS_MESSAGE = "Lista de produtos não pode ser vazia.";

    public static void validateLot(final LotDTO lotDTO) throws LotInvalidExcecption {

        if (Objects.isNull(lotDTO.getBarcodeDTO())) {
            throw new LotInvalidExcecption(INVALID_BARCODE_MESSAGE);
        }

        if (Objects.isNull(lotDTO.getProductDTOS())) {
            throw new LotInvalidExcecption(INVALID_PRODUCTS_MESSAGE);
        }

        if (lotDTO.getProductDTOS().isEmpty()) {
            throw new LotInvalidExcecption(INVALID_PRODUCTS_MESSAGE);
        }

        for (ProductDTO productDTO : lotDTO.getProductDTOS()) {
            ProductValidator.validateProductDto(productDTO);
        }
    }
}
