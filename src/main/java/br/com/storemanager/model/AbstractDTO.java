package br.com.storemanager.model;

import java.util.UUID;

public class AbstractDTO {

    private UUID id;

    public AbstractDTO() {
        this.id = UUID.randomUUID();
    }
}
