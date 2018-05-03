package br.com.storemanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarcodeDTO extends AbstractDTO {

    @Getter
    private String code;
}
