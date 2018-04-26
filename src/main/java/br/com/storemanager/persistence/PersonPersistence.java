package br.com.storemanager.persistence;

import br.com.storemanager.model.Person;

public class PersonPersistence implements PersistenceService<Person> {

    public PersonPersistence() {
        super();
    }

    public void persist(final Person person) {
        super.save(person);
    }

    public void update(final Person person) {
        super.update(person);
    }

    public void delete(final Person person) {
        super.delete(person.getId());
    }
}
