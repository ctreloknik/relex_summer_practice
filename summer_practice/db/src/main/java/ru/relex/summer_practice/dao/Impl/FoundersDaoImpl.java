package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.FoundersDao;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Founders;
import ru.relex.summer_practice.db.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public class FoundersDaoImpl extends GenericCrudDaoImpl<Founders, Long> implements FoundersDao{
    public Founders Create(Founders founders){
        return super.Create(founders);
    }

    public Founders Read(Long id){
        return super.Read(id);
    }

    public Collection<Founders> ReadAll(){
        return super.ReadAll();
    }

    public Founders Update(Founders founders){
        return super.Update(founders);
    }

    public void Delete(Long id){
        super.Delete(id);
    }

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
