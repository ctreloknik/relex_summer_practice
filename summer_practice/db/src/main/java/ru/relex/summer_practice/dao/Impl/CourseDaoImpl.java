package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.CourseDao;
import ru.relex.summer_practice.db.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by Eugene on 12.07.2015.
 */
public class CourseDaoImpl extends GenericCrudDaoImpl<Course, Long> implements CourseDao {
    public CourseDaoImpl(){
        super(Course.class);
    }

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

    public List<Course> getNexEvents(){
        String jpql = "SELECT DISTINCT c from Course c WHERE c.startDate > current_date ORDER BY c.startDate";
        return this.EexecuteQuery(jpql);
    }

}
