package br.com.storemanager.converter;

import br.com.storemanager.model.Person;
import br.com.storemanager.model.PersonDTO;

public class PersonConverter {

    public static Person fromPersonDTOToperson(final PersonDTO personDTO) {
        final Person person = new Person(personDTO.getName());
        return person;
    }

    public static PersonDTO fromPersonToPersonDTO(final Person person) {
        final PersonDTO personDTO = new PersonDTO(person.getName());
        return personDTO;
    }
}
