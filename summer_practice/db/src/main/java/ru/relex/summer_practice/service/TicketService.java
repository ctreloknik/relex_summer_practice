package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.TicketDaoImpl;
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
public class TicketService extends TicketDaoImpl {

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
    public int getPrice(Ticket ticket) {
        return super.getPrice(ticket);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Ticket Create(Ticket ticket) {
        return super.Create(ticket);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Ticket Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Ticket> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Ticket Update(Ticket ticket) {
        return super.Update(ticket);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Ticket> getTicketsForBuying() {
        return super.getTicketsForBuying();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Ticket> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Ticket> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
