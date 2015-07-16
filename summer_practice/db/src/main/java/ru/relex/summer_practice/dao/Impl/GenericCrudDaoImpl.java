package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.GenericCrudDao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public class GenericCrudDaoImpl<T, PK>  extends AbstructDaoImpl<T, PK> implements GenericCrudDao<T, PK> {
    private Class<T> instance;

    public GenericCrudDaoImpl(Class<T> instance) {
        this.instance = instance;
    }

    public T Create(T t) {
        em = getEntityManager();
        t = em.merge(t);
        closeEntityManager();
        return t;
    }

    public T Read(PK id) {
        em  = getEntityManager();
        T t = em.find(instance, id);
        closeEntityManager();
        return t;
    }


    public List<T> ReadAll() {
        em  = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(instance);
        Root<T> rootEntry = cq.from(instance);
        CriteriaQuery<T> all = cq.select(rootEntry);
        List<T> t = em.createQuery(all).getResultList();
        closeEntityManager();
        return t;
    }

    public T Update(T t) {
        em  = getEntityManager();
        t = em.merge(t);
        closeEntityManager();
        return t;
    }

    public void Delete(PK id) {
        em  = getEntityManager();
        T t = em.find(instance, id);
        em.remove(t);
        closeEntityManager();
    }

    @Override
    protected EntityManager getEntityManager() {
        em = Singleton.CreateEntityManager();
        em.getTransaction().begin();
        return em;
    }

    @Override
    protected void closeEntityManager() {
        if (em.getTransaction().isActive()) em.getTransaction().commit();
        if (em != null && em.isOpen()) em.close();
    }
}
