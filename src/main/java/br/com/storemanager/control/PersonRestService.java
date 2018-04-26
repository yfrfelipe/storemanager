package br.com.storemanager.control;

import br.com.storemanager.model.PersonDTO;
import br.com.storemanager.service.PersonService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{userId}/person")
public class PersonRestService implements Controller<PersonDTO> {

    private final PersonService personService;

    @Autowired
    PersonRestService(final PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public void doPost(PersonDTO entityDTO) {
        personService.create(entityDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public void doGet(UUID id) {

    }

    @RequestMapping(method = RequestMethod.PUT)
    @Override
    public void doPut(PersonDTO entityDTO) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
    @Override
    public void doDelete(@PathVariable String userId, @PathVariable String personId) {

    }
}
