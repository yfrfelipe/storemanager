package br.com.storemanager.persistence;

import br.com.storemanager.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersistenceService<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
