package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.FoundersDaoImpl;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Founders;
import ru.relex.summer_practice.db.Person;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikita on 14.07.2015.
 */

@Stateless
public class FoundersService extends FoundersDaoImpl{

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
    public Collection getConferensesByPerson(Person person) {
        return super.getConferensesByPerson(person);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Collection getPersonsByConference(Conference conference) {
        return super.getPersonsByConference(conference);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Founders Create(Founders founders) {
        return super.Create(founders);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Founders Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Founders> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Founders Update(Founders founders) {
        return super.Update(founders);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Founders> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Founders> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
