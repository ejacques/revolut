package br.com.erick.revolut.repository;

import br.com.erick.revolut.repository.entity.AccountEntity;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class AccountsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AccountsRepository(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public List<AccountEntity> findAll() {
        return entityManager
                .createQuery("select a from AccountEntity as a", AccountEntity.class)
                .getResultList();
    }

    @Transactional
    public void insert(AccountEntity entity) {
        entityManager.merge(entity);
    }
}
