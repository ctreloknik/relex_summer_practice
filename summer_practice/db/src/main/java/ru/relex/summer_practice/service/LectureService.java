package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.LectureDaoImpl;
import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.db.Lecture;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikita on 14.07.2015.
 */

@Stateless
public class LectureService extends LectureDaoImpl{
    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected void closeEntityManager() {}

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Date getDatetime(Lecture lecture) {
        return super.getDatetime(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String getDescription(Lecture lecture) {
        return super.getDescription(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Lecture Create(Lecture lecture) {
        return super.Create(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Lecture Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Lecture> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Lecture Update(Lecture lecture) {
        return super.Update(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String getTopic(Lecture lecture) {
        return super.getTopic(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Date getStartTimeByCourse(Course course) {
        return super.getStartTimeByCourse(course);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Lecture> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Lecture> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }
}
