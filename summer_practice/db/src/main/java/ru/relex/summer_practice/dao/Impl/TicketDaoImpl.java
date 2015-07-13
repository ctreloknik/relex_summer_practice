package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.TicketDAO;
import ru.relex.summer_practice.db.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Nikita on 12.07.2015.
 */
public class TicketDAOImpl extends GenericCRUDDAOImpl<Ticket, Long> implements TicketDAO {
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
