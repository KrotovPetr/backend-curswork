package com.cursproject.repository;

import org.postgresql.shaded.com.ongres.scram.common.util.Preconditions;
import org.springframework.lang.NonNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public abstract class AbstractRepository<M,I> {
    protected Class<M> class1;
    public abstract void init();

    public void setClass1(final Class<M> clas1ToSet) {
        class1 = Preconditions.checkNotNull(clas1ToSet, null);
    }
    public Optional<M> findById(@NonNull I id) {
        return Optional.of(entityManager.find(class1, id));
    }
    @PersistenceContext
    protected EntityManager entityManager;
    public void delete(M model) {
        entityManager.remove(model);
    }

    public void create(M newModel) {
        entityManager.persist(newModel);
    }

    public void update(M changedModel) {
        entityManager.merge(changedModel);
    }
}
