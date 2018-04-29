package br.com.storemanager.service;

import br.com.storemanager.model.PersonDTO;
import br.com.storemanager.persistence.PersonPersistence;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonPersistence personPersistence;

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
