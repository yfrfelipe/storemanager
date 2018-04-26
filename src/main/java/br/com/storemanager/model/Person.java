package br.com.storemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name = "tb_person")
public class Person extends AbstractEntity {

    @Column (nullable = false)
    private String name;

    public Person(final String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
