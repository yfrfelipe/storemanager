package br.com.storemanager.model.reservation;

import br.com.storemanager.model.AbstractEntity;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @NonNull
    private Set<ProductByQuantity> productByQuantity;
    @Column(nullable = false)
    @Getter
    @NonNull
    private Long timestamp;
    @Column
    @Getter
    @NonNull
    private Long reserveTime;
}
