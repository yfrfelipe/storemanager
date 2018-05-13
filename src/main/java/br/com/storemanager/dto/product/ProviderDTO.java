package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
public class ProviderDTO extends AbstractDTO {

    @Getter
    @Setter
    @NonNull
    private Integer providerId;
}
