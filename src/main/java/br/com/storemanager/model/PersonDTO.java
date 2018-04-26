package br.com.storemanager.model;

public class PersonDTO extends AbstractDTO {

    private String name;

    public PersonDTO(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
