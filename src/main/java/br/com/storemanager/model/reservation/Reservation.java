package br.com.storemanager.model.reservation;

import br.com.storemanager.model.AbstractEntity;
import java.util.Map;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "tb_reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Reservation extends AbstractEntity {

    @Id
    @Getter
    @Column(nullable = false, updatable = false)
    @NonNull
    private UUID reservationID;
    @ElementCollection
    @MapKeyColumn
    @Column
    @CollectionTable(name = "product_by_quantity", joinColumns = @JoinColumn(name = "product_id"))
    @Getter
    @NonNull
    private Map<Integer, Integer> productByQuantity;
    @Column(nullable = false)
    @Getter
    @NonNull
    private Long timestamp;
}
