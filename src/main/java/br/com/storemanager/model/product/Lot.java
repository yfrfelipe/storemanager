package br.com.storemanager.model.product;

import br.com.storemanager.model.AbstractEntity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "tb_lot")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Lot extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lot_gen", sequenceName = "lot_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @NonNull
    private Barcode barcode;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @NonNull
    private Set<Product> products;

    @OneToOne
    @Getter
    @NonNull
    private Provider provider;
}
