package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.ConferenceDaoImpl;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Person;

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

    @Override
    protected void closeEntityManager() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

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
    public List<Conference> getModeratedConference(Boolean moderated) {
        return super.getModeratedConference(moderated);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Conference getConferenceByName(String name) {
        return super.getConferenceByName(name);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Conference> getTicketsForBuying(Person person) {
        return super.getTicketsForBuying(person);
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
