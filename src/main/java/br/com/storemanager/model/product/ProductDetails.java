package br.com.storemanager.model.product;

import br.com.storemanager.model.AbstractEntity;
import java.time.LocalDateTime;
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
import org.hibernate.annotations.CreationTimestamp;

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

    @Column
    @Getter
    @NonNull
    @CreationTimestamp
    private LocalDateTime createDateTime;

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
