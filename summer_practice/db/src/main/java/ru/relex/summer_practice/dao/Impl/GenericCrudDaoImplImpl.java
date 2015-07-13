package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.GenericCrudDao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public class GenericCrudDaoImplImpl<T, PK>  extends AbstructDaoImpl<T, PK> implements GenericCrudDao<T, PK> {
    private Class<T> instance;

    public GenericCrudDaoImplImpl() {
        this.instance = (Class<T>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public T Create(T t) {
        EntityManager em = getEntityManager();
        t = em.merge(t);
        closeEntityManager(em);
        return t;
    }

    public T Read(PK id) {
        EntityManager em = getEntityManager();
        T t = em.find(instance, id);
        closeEntityManager(em);
        return t;
    }


    public List<T> ReadAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(instance);
        Root<T> rootEntry = cq.from(instance);
        CriteriaQuery<T> all = cq.select(rootEntry);
        List<T> t = em.createQuery(all).getResultList();
        closeEntityManager(em);
        return t;
    }

    public T Update(T t) {
        EntityManager em = getEntityManager();
        t = em.merge(t);
        closeEntityManager(em);
        return t;
    }

    public void Delete(PK id) {
        EntityManager em = getEntityManager();
        T t = em.find(instance, id);
        em.remove(t);
        closeEntityManager(em);
    }

    @Override
    protected EntityManager getEntityManager() {
        EntityManager em = Singleton.CreateEntityManager();
        em.getTransaction().begin();
        return em;
    }

    @Override
    protected void closeEntityManager(EntityManager em) {
        if (em.getTransaction().isActive()) em.getTransaction().commit();
        if (em != null && em.isOpen()) em.close();
    }
}
