package br.com.storemanager.persistence;

import br.com.storemanager.model.product.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

    @Transactional
    @Override
    Iterable<Product> findAllById(Iterable<Integer> iterable);
}
