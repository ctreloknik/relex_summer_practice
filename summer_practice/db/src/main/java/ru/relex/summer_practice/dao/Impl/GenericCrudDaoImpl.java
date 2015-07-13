package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.GenericCrudDao;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by Sasha on 12.07.2015.
 */
public class GenericCrudDaoImpl<T, PK> implements GenericCrudDao<T, PK> {
    private Class<T> instance;

    public GenericCrudDaoImpl(){
        this.instance = (Class<T>)(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public T Create(T t){
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
            return t;
        }finally {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public T Read (PK id){
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            return em.find(instance, id);
        }finally {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

   
    public List<T> ReadAll() {
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(instance);
            Root<T> rootEntry = cq.from(instance);
            CriteriaQuery<T> all = cq.select(rootEntry);
            return em.createQuery(all).getResultList();
        }finally {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public T Update(T t) {
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
            return t;
        }finally {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    public void Delete(PK id){
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            em.getTransaction().begin();
            T t = em.find(instance, id);
            em.remove(t);
            em.getTransaction().commit();
        }finally {
			if (em.getTransaction().isActive()) em.getTransaction().rollback();
			if (em != null && em.isOpen()) em.close();
        }
    }

    protected List<T> EexecuteQuery(String jpql, Map<String,Object> parametres){
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            Query query = em.createQuery(jpql);
            for(Map.Entry<String,Object> entry : parametres.entrySet()){
                query.setParameter(entry.getKey(),entry.getValue());
            }
            return query.getResultList();
        }finally {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }

    protected List<T> EexecuteQuery(String jpql){
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            return em.createQuery(jpql).getResultList();
        }finally {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            if (em != null && em.isOpen()) em.close();
        }
    }
}
