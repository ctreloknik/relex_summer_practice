package ru.relex.summer_practice.web.service;

import ru.relex.summer_practice.dao.Impl.ConferenceDaoImpl;
import ru.relex.summer_practice.db.Conference;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikita on 14.07.2015.
 */

@Stateless
public class ConferenceService extends ConferenceDaoImpl {
    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    protected void closeEntityManager() {
        super.closeEntityManager();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String getName(Conference conference) {
        return super.getName(conference);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String getDescription(Conference conference) {
        return super.getDescription(conference);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Conference Create(Conference conference) {
        return super.Create(conference);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Conference Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Conference> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Conference Update(Conference conference) {
        return super.Update(conference);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Conference> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Conference> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
