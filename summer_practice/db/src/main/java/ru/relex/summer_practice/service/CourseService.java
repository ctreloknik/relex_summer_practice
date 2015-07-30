package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.CourseDaoImpl;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Course;

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
public class CourseService extends CourseDaoImpl{

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
    public Date getStartDate(Course course) {
        return super.getStartDate(course);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Date getEndDate(Course course) {
        return super.getEndDate(course);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Course Create(Course course) {
        return super.Create(course);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Course Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Course> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Course Update(Course course) {
        return super.Update(course);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Course> getNexEvents() {
        return super.getNexEvents();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Course> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<Course> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Course> getCourseByConferenceId(Long id) {
        return super.getCourseByConferenceId(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Course getCourseById(Long id) {
        return super.getCourseById(id);
    }


}
