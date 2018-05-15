package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotDTO extends AbstractDTO {

    @Getter
    @Setter
    @NonNull
    private BarcodeDTO barcodeDTO;

    @Getter
    @Setter
    @NonNull
    private Set<ProductDTO> productDTOS;

    @Getter
    @Setter
    @NonNull
    private Integer providerId;
}
