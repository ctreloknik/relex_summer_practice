package ru.relex.summer_practice.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import ru.relex.summer_practice.dao.GenericCrudDao;

/**
 * Created by Sasha on 12.07.2015.
 */
public class GenericCrudDaoImpl<T, PK> implements GenericCrudDao<T, PK> {
    private Class<T> instance;

    public GenericCrudDaoImpl(){
        this.instance = (Class<T>)(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public T Create(T t){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return t;
    }

    public T Read (PK id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager em = emf.createEntityManager();
        T t = em.find(instance, id);
        em.close();
        emf.close();
        return t;
    }

    public T Update(T t) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        t = em.merge(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return t;
    }

    public void Delete(T t){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
