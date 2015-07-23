package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.TicketDao;
import ru.relex.summer_practice.db.Ticket;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<Ticket> getTicketsForBuying(){
        String jpql = "SELECT t from Ticket t WHERE t.conference = (SELECT c.conference FROM Course c GROUP BY c.conference, c.startDate HAVING c.startDate > current_date)";
        System.out.println(" getTicketsForBuying worked ");
        List<Ticket> res = this.EexecuteQuery(jpql);
        System.out.println(" query worked");
        return res;
    }

}
