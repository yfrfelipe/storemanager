package br.com.storemanager.persistence;

import br.com.storemanager.model.reservation.Reservation;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, UUID> {
}
