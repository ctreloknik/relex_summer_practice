package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.ConferenceDao;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.CourseService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Eugene on 12.07.2015.
 */
public class ConferenceDaoImpl extends GenericCrudDaoImpl<Conference, Long> implements ConferenceDao {
    public ConferenceDaoImpl(){
        super(Conference.class);
    }

    @Override
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

    @Override
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

    @Override
    public Conference getConferenceByName(String name) {
        String jpa = "SELECT c FROM Conference c WHERE c.name = :name";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("name",name);
        List<Conference> conference = this.EexecuteQuery(jpa,parameters);
        for (Conference conf : conference) {

        }
        if (conference.size() != 1){
            return null;
        }
        return conference.get(0);
    }

    @Override
    public Conference getConferenceById(Long id) {
        String jpa = "SELECT c FROM Conference c WHERE c.id = :id";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("id",id);
        List<Conference> conference = this.EexecuteQuery(jpa,parameters);
        return conference.get(0);
    }

    @Override
    public List<Conference> getModeratedConference(Boolean moderated) {
        String jpa = "SELECT c FROM Conference c WHERE c.moderated = :moderated";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("moderated", moderated);
        return this.EexecuteQuery(jpa, parameters);
    }

    @Override
    public Conference getConferenceForShow() {
        List<Conference> conferences = getModeratedConference(true);
        return conferences.get(0);
    }

    public List<Conference> getTicketsForBuying(Person person){
        String jpql = "SELECT DISTINCT c from Conference c, Course co WHERE c = co.conference and co.endDate>current_date" +
                " and NOT EXISTS(SELECT pt.conference FROM PersonTicket pt WHERE pt.person = :person and c = pt.conference)";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("person", person);
        return this.EexecuteQuery(jpql, parameters);
    }
}
