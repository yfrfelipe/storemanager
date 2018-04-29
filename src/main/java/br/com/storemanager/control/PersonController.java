package br.com.storemanager.control;

import br.com.storemanager.model.PersonDTO;
import br.com.storemanager.service.PersonService;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController implements AbstractWebService<PersonDTO> {

    @Autowired
    private PersonService personServiceImpl;

    @PostMapping("person")
    @Override
    public void doPost(Map<String, PersonDTO> modelDTO) {
        personServiceImpl.create(modelDTO.values().iterator().next());
    }

    @Override
    public void doGet(UUID id) {

    }

    @Override
    public void doPut(Map<String, PersonDTO> modelDTO) {

    }

    @Override
    public void doDelete(Map<String, PersonDTO> modelDTO) {

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PersonController.class, args);
    }
}
