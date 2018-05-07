package br.com.storemanager.persistence;

import br.com.storemanager.model.product.Lot;
import org.springframework.data.repository.CrudRepository;

public interface LotRepository extends CrudRepository<Lot, Integer> {
}
