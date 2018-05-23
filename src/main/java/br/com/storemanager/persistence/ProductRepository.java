package br.com.storemanager.persistence;

import br.com.storemanager.model.product.Product;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Transactional
    @Override
    Iterable<Product> findAllById(Iterable<Integer> iterable);
}
