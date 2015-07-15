package ru.relex.summer_practice.web.service;

import ru.relex.summer_practice.dao.Impl.RatingDaoImpl;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;
import ru.relex.summer_practice.db.Rating;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikita on 14.07.2015.
 */

@Stateless
public class RatingService extends RatingDaoImpl {
    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    protected void closeEntityManager() {
        super.closeEntityManager();
    }

    @Override
    public void AddRating(Person person, Question question, int rating) {
        super.AddRating(person, question, rating);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Rating Create(Rating rating) {
        return super.Create(rating);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Rating Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Rating> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Rating Update(Rating rating) {
        return super.Update(rating);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Rating> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Rating> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
