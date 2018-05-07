package br.com.storemanager.persistence;

import br.com.storemanager.model.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
