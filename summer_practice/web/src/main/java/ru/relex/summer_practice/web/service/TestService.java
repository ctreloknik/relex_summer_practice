package ru.relex.summer_practice.web.service;

import ru.relex.summer_practice.dao.Impl.TestDaoIml;
import ru.relex.summer_practice.dao.TestDao;
import ru.relex.summer_practice.db.Person;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Sasha on 14.07.2015.
 */
@Stateless
public class TestService extends TestDaoIml{

    public  String getDa(){
        return "da";
    }

    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Person> readAll() {
        return super.readAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
