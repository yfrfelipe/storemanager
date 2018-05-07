package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractDTO;
import java.util.Set;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class LotDTO extends AbstractDTO {

    @Getter
    @Setter
    @NonNull
    private BarcodeDTO barcodeDTO;

    @Getter
    @Setter
    @NonNull
    private Set<ProductDTO> productDTOS;
}
