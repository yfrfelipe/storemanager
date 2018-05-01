package br.com.storemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "tb_person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product extends AbstractEntity {

    @Id
    @Getter
    @Setter
    private Long id;

    @Column (nullable = false)
    @Getter
    @Setter
    private String name;
}
