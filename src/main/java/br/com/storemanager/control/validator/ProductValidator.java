package br.com.storemanager.control.validator;

import br.com.storemanager.dto.product.ProductDTO;
import br.com.storemanager.exception.northbound.product.ProductInvalidException;
import java.util.Objects;
import org.apache.logging.log4j.util.Strings;

public class ProductValidator extends AbstractValidator {

    private static final String BARCODE_ERROR_MESSAGE = "Código de barras não inserido para este produto.";
    private static final String PRODUCT_NAME_ERROR_MESSAGE = "O produto precisa conter um nome válido.";
    private static final String PRODUCT_CODE_ERROR_MESSAGE = "O produto precisa conter um código válido.";

    public static void validateProductDto(final ProductDTO productDTO) throws ProductInvalidException {
        if (Objects.isNull(productDTO.getBarcodeDTO())) {
            throw new ProductInvalidException(BARCODE_ERROR_MESSAGE);
        }

        if (Objects.isNull(productDTO.getName())
                || Strings.isEmpty(productDTO.getName())
                || Strings.isBlank(productDTO.getName())) {
            throw new ProductInvalidException(PRODUCT_NAME_ERROR_MESSAGE);
        }

        if (Objects.isNull(productDTO.getProductCode())
                || Strings.isEmpty(productDTO.getProductCode())
                || Strings.isBlank(productDTO.getProductCode())) {
            throw new ProductInvalidException(PRODUCT_CODE_ERROR_MESSAGE);
        }
    }

}
