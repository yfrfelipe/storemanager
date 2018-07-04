package br.com.storemanager.persistence;

import br.com.storemanager.model.reservation.Reservation;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, UUID> {

    @Query(value = "SELECT * FROM tb_reservation WHERE reserve_time >= ?1", nativeQuery = true)
    Set<Reservation> retreiveExpiredReservations(Long currentDate);
}
