package br.com.storemanager.model.product;

import br.com.storemanager.model.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "tb_barcode")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Barcode extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "barcode_gen", sequenceName = "barcode_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false, updatable = false)
    @Getter
    private String code;
}
