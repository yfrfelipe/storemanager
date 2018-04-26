package br.com.storemanager.service;

import br.com.storemanager.model.PersonDTO;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class PersonServiceImpl implements PersonService {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceImpl.class, args);
    }

    @Override
    public void create(PersonDTO entityDTO) {

    }

    @Override
    public void update(PersonDTO entityDTO) {

    }

    @Override
    public void delete(UUID id) {

    }
}
