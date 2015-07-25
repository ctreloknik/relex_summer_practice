package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.LectureDao;
import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.db.Lecture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Eugene on 12.07.2015.
 */
public class LectureDaoImpl extends GenericCrudDaoImpl<Lecture, Long> implements LectureDao {
    public String getTopic(Lecture lecture) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long lecture_id = lecture.getId();
            return em.find(Lecture.class, lecture_id).getTopic();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public LectureDaoImpl(){
        super(Lecture.class);
    }

    public Date getDatetime(Lecture lecture) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long lecture_id = lecture.getId();
            return em.find(Lecture.class, lecture_id).getDatetime();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public String getDescription(Lecture lecture) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long lecture_id = lecture.getId();
            return em.find(Lecture.class, lecture_id).getDescription();
        } finally {
            if (em != null ) em.close();
            if (emf != null) emf.close();
        }
    }

    public Date getStartTimeByCourse(Course course) {
        String jpql = "select l from Lecture l where l.course = :course ORDER BY l.datetime";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("course",course);
        List<Lecture> result = this.EexecuteQuery(jpql, parameters);
        if (result.size() == 0) {
            return null;
        }
        return result.get(0).getDatetime();
    }
}
