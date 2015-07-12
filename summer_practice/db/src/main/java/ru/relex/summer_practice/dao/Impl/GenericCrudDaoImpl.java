package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.GenericCrudDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * Created by Sasha on 12.07.2015.
 */
public class GenericCrudDaoImpl<T, PK> implements GenericCrudDao<T, PK> {
    private Class<T> instance;

    public GenericCrudDaoImpl(){
        this.instance = (Class<T>)(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public T Create(T t){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
            return t;
        }finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public T Read (PK id){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            return em.find(instance, id);
        }finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public Collection<T> ReadAll() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(instance);
            Root<T> rootEntry = cq.from(instance);
            CriteriaQuery<T> all = cq.select(rootEntry);
            return em.createQuery(all).getResultList();
        }finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public T Update(T t) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
            return t;
        }finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public void Delete(PK id){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            T t = em.find(instance, id);
            em.remove(t);
            em.getTransaction().commit();
        }finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }
}
