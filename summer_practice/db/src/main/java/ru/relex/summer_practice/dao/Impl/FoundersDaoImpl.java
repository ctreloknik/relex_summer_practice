package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.FoundersDAO;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Founders;
import ru.relex.summer_practice.db.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by Nikita on 12.07.2015.
 */
public class FoundersDaoImpl extends GenericCRUDDAOImpl<Founders, Long> implements FoundersDAO {
    public Collection getConferensesByPerson(Person person) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Query query = em.createQuery("select f from FOUNDERS f where f.person = :person")
                    .setParameter("person", person);
            return query.getResultList();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public Collection getPersonsByConference(Conference conference) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Query query = em.createQuery("select f from FOUNDERS f where f.conference = :conference")
                    .setParameter("conference", conference);
            return query.getResultList();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }
}
