package br.com.storemanager.model.product;

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

@Entity(name = "tb_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Brand {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "brand_gen", sequenceName = "brand_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false)
    @NonNull
    @Getter
    private String name;
}
