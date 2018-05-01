package br.com.storemanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends AbstractDTO {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;

}
