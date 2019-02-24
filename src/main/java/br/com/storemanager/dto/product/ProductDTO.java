package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
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
public class ProductDTO extends AbstractDTO {

    @Getter
    @NonNull
    private Integer productID;

    @Getter
    @NonNull
    private String name;

    @Getter
    @NonNull
    private String productCode;

    // Nomenclatura Comum Mercosul
    @Getter
    @Setter
    private String ncm;

    // Código Fiscal de Operações e Prestações
    @Getter
    @Setter
    private String cofp;

    // Código de Situação Tributária
    @Getter
    @Setter
    private String cst;

    @Getter
    @NonNull
    private BarcodeDTO barcodeDTO;

    @Getter
    @NonNull
    private ProductDetailsDTO productDetailsDTO;

}
