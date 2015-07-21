package ru.relex.summer_practice.service;


import ru.relex.summer_practice.dao.Impl.PersonDaoImpl;
import ru.relex.summer_practice.db.Person;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

/**
 * Created by Sasha on 14.07.2015.
 */

@Stateless
public class PersonService extends PersonDaoImpl{
    @Override
    public Person getUserByEmail(String email) {
        return super.getUserByEmail(email);
    }

    @Override
    protected void closeEntityManager() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Person Update(Person person) {
        return super.Update(person);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Person> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Person Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Person Create(Person person) {
        return super.Create(person);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Person getUserByNickname(String login) {
        return super.getUserByNickname(login);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Person Login(String login, String password) {
        return super.Login(login, password);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Person> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Person> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
