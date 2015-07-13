package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.ConferenceDao;
import ru.relex.summer_practice.db.Conference;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Eugene on 12.07.2015.
 */
public class ConferenceDaoImpl extends GenericCrudDaoImpl<Conference, Long> implements ConferenceDao {
    public String getName(Conference conference) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long conference_id = conference.getId();
            return em.find(Conference.class, conference_id).getName();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public String getDescription(Conference conference) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long conference_id = conference.getId();
            return em.find(Conference.class, conference_id).getDescription();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }
}
