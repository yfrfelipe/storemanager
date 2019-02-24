package br.com.storemanager.persistence;

import br.com.storemanager.model.product.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LotRepository extends CrudRepository<Lot, Integer>, PagingAndSortingRepository<Lot, Integer> {
}
