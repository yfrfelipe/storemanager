package br.com.storemanager.model.product;

import br.com.storemanager.model.AbstractEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity (name = "tb_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_gen", sequenceName = "product_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column (nullable = false)
    @Getter
    @NonNull
    private String name;

    @Column (nullable = false)
    @Getter
    @NonNull
    private String productCode;

    // Nomenclatura Comum Mercosul
    @Column
    @Getter
    @Setter
    private String ncm;

    // Código Fiscal de Operações e Prestações
    @Column
    @Getter
    @Setter
    private String cofp;

    // Código de Situação Tributária
    @Column
    @Getter
    @Setter
    private String cst;

    @Getter
    @NonNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Barcode barcode;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @NonNull
    private ProductDetails productDetails;

}
