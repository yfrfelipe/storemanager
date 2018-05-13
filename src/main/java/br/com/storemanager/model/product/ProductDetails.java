package br.com.storemanager.model.product;

import br.com.storemanager.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name = "tb_product_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDetails extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_details_gen", sequenceName = "product_details_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

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
