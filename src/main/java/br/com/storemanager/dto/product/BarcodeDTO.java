package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarcodeDTO extends AbstractDTO {

    @Getter
    @NonNull
    @NotEmpty
    private String code;
}
