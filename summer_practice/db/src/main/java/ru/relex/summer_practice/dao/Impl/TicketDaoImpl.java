package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.TicketDao;
import ru.relex.summer_practice.db.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * Created by Nikita on 12.07.2015.
 */
public class TicketDaoImpl extends GenericCrudDaoImpl<Ticket, Long> implements TicketDao {
    public Ticket Create(Ticket ticket){
        return super.Create(ticket);
    }

    public Ticket Read(Long id){
        return super.Read(id);
    }

    public Collection<Ticket> ReadAll(){
        return super.ReadAll();
    }

    public Ticket Update(Ticket ticket){
        return super.Update(ticket);
    }

    public void Delete(Long id){
        super.Delete(id);
    }

    public int getPrice(Ticket ticket) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long ticket_id = ticket.getId();
            return em.find(Ticket.class, ticket_id).getPrice();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }
}
