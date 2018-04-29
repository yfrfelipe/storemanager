package br.com.storemanager.control;

import br.com.storemanager.model.PersonDTO;
import br.com.storemanager.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Api(value = "storemanager", description = "Operations.")
public class PersonController implements AbstractWebService<PersonDTO> {

    @Autowired
    private PersonService personServiceImpl;

    @PostMapping(path = "/people")
    @Override
    public void doPost(@RequestBody PersonDTO modelDTO) {
        personServiceImpl.create(modelDTO);
    }

    @GetMapping(path = "/people")
    @ApiOperation(value = "Search for a gicen ID")
    @Override
    public void doGet(@PathVariable String id) {

    }

    @Override
    public void doPut(PersonDTO modelDTO) {

    }

    @Override
    public void doDelete(PersonDTO modelDTO) {

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PersonController.class, args);
    }
}
