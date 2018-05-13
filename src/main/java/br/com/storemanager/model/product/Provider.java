package br.com.storemanager.model.product;

import br.com.storemanager.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name = "tb_provider")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Provider extends AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "provider_gen", sequenceName = "provider_seq")
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer id;

    @Column
    @Getter
    @NonNull
    private Integer providerId;
}
