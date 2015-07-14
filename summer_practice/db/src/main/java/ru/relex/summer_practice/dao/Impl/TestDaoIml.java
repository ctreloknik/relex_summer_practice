package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.TestDao;
import ru.relex.summer_practice.db.Person;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Sasha on 14.07.2015.
 */
public class TestDaoIml implements TestDao {

    protected EntityManager em;

    @Override
    public List<Person> readAll() {
        em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);
        List<Person> t = em.createQuery(all).getResultList();
        return t;
    }

    protected EntityManager getEntityManager(){
        return em;
    }
}
