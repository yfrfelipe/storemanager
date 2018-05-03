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

@Entity(name = "category_lot")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_gen", sequenceName = "category_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column(nullable = false)
    @Getter
    @NonNull
    private String name;
}
