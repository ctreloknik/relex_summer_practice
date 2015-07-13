package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonTicketDAO;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;
import ru.relex.summer_practice.db.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by Nikita on 12.07.2015.
 */
public class PersonTicketDAOImpl extends GenericCRUDDAOImpl<PersonTicket, Long> implements PersonTicketDAO {
    public Collection getPersonsByTickets(Ticket ticket) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Query query = em.createQuery("select pt from PERSON_TICKET pt where pt.ticket = :ticket")
                    .setParameter("ticket", ticket);
            return query.getResultList();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public Collection getTicketsByPerson(Person person) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Query query = em.createQuery("select pt from PERSON_TICKET pt where pt.person = :person")
                    .setParameter("person", person);
            return query.getResultList();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }
}
