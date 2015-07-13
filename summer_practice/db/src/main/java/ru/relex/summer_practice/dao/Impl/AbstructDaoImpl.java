package ru.relex.summer_practice.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by Sasha on 13.07.2015.
 */
public abstract class AbstructDaoImpl<T, PK>{

    protected abstract EntityManager getEntityManager();
    protected abstract void closeEntityManager(EntityManager em);

    protected List<T> EexecuteQuery(String jpql, Map<String,Object> parametres){
        EntityManager em = getEntityManager();
        Query query = em.createQuery(jpql);
        for(Map.Entry<String,Object> entry : parametres.entrySet()){
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List<T> result = query.getResultList();
        closeEntityManager(em);
        return result;
    }

    protected List<T> EexecuteQuery(String jpql){
        EntityManager em = getEntityManager();
        List<T> result = em.createQuery(jpql).getResultList();
        closeEntityManager(em);
        return result;
    }

}
