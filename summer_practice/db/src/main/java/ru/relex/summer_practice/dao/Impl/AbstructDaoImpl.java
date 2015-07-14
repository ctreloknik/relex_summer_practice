package ru.relex.summer_practice.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by Sasha on 13.07.2015.
 */
public abstract class AbstructDaoImpl<T, PK>{

    protected EntityManager em;
    protected abstract EntityManager getEntityManager();
    protected abstract void closeEntityManager();

    protected List<T> EexecuteQuery(String jpql, Map<String,Object> parametres){
        em = getEntityManager();
        Query query = em.createQuery(jpql);
        for(Map.Entry<String,Object> entry : parametres.entrySet()){
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List<T> result = query.getResultList();
        closeEntityManager();
        return result;
    }

    protected List<T> EexecuteQuery(String jpql){
        em = getEntityManager();
        List<T> result = em.createQuery(jpql).getResultList();
        closeEntityManager();
        return result;
    }

}
