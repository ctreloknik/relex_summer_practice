package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.TicketDao;
import ru.relex.summer_practice.db.Ticket;

import javax.persistence.EntityManager;

/**
 * Created by Nikita on 12.07.2015.
 */
public class TicketDaoImpl extends GenericCrudDaoImpl<Ticket, Long> implements TicketDao {
    public TicketDaoImpl(){
        super(Ticket.class);
    }

    public int getPrice(Ticket ticket) {
        EntityManager em = null;
        try {
            em = Singleton.CreateEntityManager();
            Long ticket_id = ticket.getId();
            return em.find(Ticket.class, ticket_id).getPrice();
        } finally {
            if (em != null ) em.close();
        }
    }
}
