package br.com.storemanager.persistence;

import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class ConnectionFactory {

    private static final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPAUnit");
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (Objects.isNull(entityManager)) {
            entityManager = managerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static Session getSession() {
        return (Session) entityManager.getDelegate();
    }
}
