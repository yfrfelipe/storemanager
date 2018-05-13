package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDTO extends AbstractDTO {

    @Column(nullable = false)
    @Getter
    @NonNull
    private Long sellPrice;

    @Column(nullable = false)
    @Getter
    @NonNull
    private Integer plotPercentage;

    @Column(nullable = false)
    @Getter
    @NonNull
    private Long buyPrice;

    @Column(nullable = false)
    @Getter
    @NonNull
    private Integer quantity;
}
