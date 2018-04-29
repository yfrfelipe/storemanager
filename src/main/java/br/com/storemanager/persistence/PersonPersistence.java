package br.com.storemanager.persistence;

import br.com.storemanager.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonPersistence extends CrudRepository<Person, Long> {
}
