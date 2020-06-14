package dev.zilioti.web.conf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.*;

public class EntityManagerProducer {

    @Produces
    @Default
    @RequestScoped
    public EntityManager create() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("paoloweb");
        return entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes @Default EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }


}
