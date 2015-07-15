package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.CourseDao;
import ru.relex.summer_practice.db.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Eugene on 12.07.2015.
 */
public class CourseDaoImplImpl extends GenericCrudDaoImplImpl<Course, Long> implements CourseDao {
    public Date getStartDate(Course course) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long course_id = course.getId();
            return em.find(Course.class, course_id).getStartDate();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public Date getEndDate(Course course) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long course_id = course.getId();
            return em.find(Course.class, course_id).getEndDate();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }
}