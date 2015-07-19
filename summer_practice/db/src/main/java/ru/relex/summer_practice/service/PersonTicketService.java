package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.PersonTicketDaoImpl;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;
import ru.relex.summer_practice.db.Ticket;

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
public class PersonTicketService extends PersonTicketDaoImpl{

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
    public List<PersonTicket> getPersonsByTickets(Ticket ticket) {
        return super.getPersonsByTickets(ticket);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<PersonTicket> getTicketsByPerson(Person person) {
        return super.getTicketsByPerson(person);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public PersonTicket Create(PersonTicket personTicket) {
        return super.Create(personTicket);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public PersonTicket Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<PersonTicket> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public PersonTicket Update(PersonTicket personTicket) {
        return super.Update(personTicket);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<PersonTicket> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<PersonTicket> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
