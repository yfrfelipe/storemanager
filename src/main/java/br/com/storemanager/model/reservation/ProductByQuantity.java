package br.com.storemanager.model.reservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "tb_product_by_quantity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductByQuantity {

    @Id
    @Getter
    @Column(nullable = false, updatable = false)
    @NonNull
    private Integer productId;
    @Column(nullable = false)
    @Getter
    @NonNull
    private Integer quantity;
}
