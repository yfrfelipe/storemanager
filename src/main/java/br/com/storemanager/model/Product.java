package br.com.storemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "tb_person")
public class Person extends AbstractEntity {

    @Id
    private Integer id;

    @Column (nullable = false)
    private String name;

    public Person(){}

    public Person(final String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
