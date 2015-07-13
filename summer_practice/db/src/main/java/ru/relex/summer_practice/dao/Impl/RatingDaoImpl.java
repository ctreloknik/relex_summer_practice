package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.RatingDao;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;
import ru.relex.summer_practice.db.Rating;

import javax.persistence.*;

/**
 * Created by Sasha on 12.07.2015.
 */
public class RatingDaoImpl extends GenericCrudDaoImpl<Rating, Long> implements RatingDao {

    public void AddRating(Person person, Question question, int rating) {
        if(question.getQuestioner().getId() != person.getId()) {
            EntityManagerFactory emf = null;
            EntityManager em = null;
            try {
                emf = Persistence.createEntityManagerFactory("PERSISTENCE");
                em = emf.createEntityManager();
                em.getTransaction().begin();
                Query query = em.createQuery("SELECT r FROM Rating r WHERE r.person = :person and r.question = :question");
                query.setParameter("person", person);
                query.setParameter("question", question);
                Rating personRating = null;
                try {
                    personRating = (Rating) query.getSingleResult();
                    if (rating != personRating.getRating())
                    {
                        personRating.setRating(rating);
                        em.merge(personRating);
                        question.setRating(question.getRating()+2*rating);
                        em.merge(question);
                    }
                } catch (NoResultException e) {
                    personRating = new Rating();
                    personRating.setPerson(person);
                    personRating.setQuestion(question);
                    personRating.setRating(rating);
                    em.merge(personRating);
                    question.setRating(question.getRating()+rating);
                    em.merge(question);
                }
                em.getTransaction().commit();
            } finally {
                if (em.getTransaction().isActive()) em.getTransaction().rollback();
                if (em != null && em.isOpen()) em.close();
                if (emf != null && emf.isOpen()) emf.close();
            }
        }
    }
}
