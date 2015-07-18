package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.QuestionDaoImpl;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;

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
public class QuestionService extends QuestionDaoImpl{

    @Override
    protected void closeEntityManager() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Question> ReadQuestionOrderByPerson(boolean desc) {
        return super.ReadQuestionOrderByPerson(desc);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Question> ReadQuestionOrderByDate(boolean desc) {
        return super.ReadQuestionOrderByDate(desc);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Question> ReadQuestionOrderByRating(boolean desc) {
        return super.ReadQuestionOrderByRating(desc);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Question> ReadQuestionByPerson(Person person) {
        return super.ReadQuestionByPerson(person);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Question> ReadQuestionByLecture(Lecture lecture) {
        return super.ReadQuestionByLecture(lecture);
    }

    @Override
    public Question Create(Question question) {
        return super.Create(question);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Question Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Question> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Question Update(Question question) {
        return super.Update(question);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Question> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Question> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
