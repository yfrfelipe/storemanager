package br.com.storemanager.dto.product;

import br.com.storemanager.dto.AbstractPageDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPageDTO extends AbstractPageDTO<ProductDTO> {

    @Getter
    @NonNull
    private Long totalElements;
    @Getter
    @NonNull
    private Integer totalPages;
    @Getter
    @NonNull
    private List<ProductDTO> content;
}
