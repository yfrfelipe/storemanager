package br.com.storemanager.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Id;

public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private UUID id;

    public AbstractEntity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
