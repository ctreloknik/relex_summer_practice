package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.LectureDao;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Eugene on 12.07.2015.
 */
public class LectutreDaoImpl extends GenericCrudDaoImpl<Lecture, Long> implements LectureDao{
    @Override
    public Lecture Create(Lecture lecture) {
        return super.Create(lecture);
    }

    @Override
    public Lecture Read(Long id) {
        return super.Read(id);
    }

    @Override
    public Collection<Lecture> ReadAll() {
        return super.ReadAll();
    }

    @Override
    public Lecture Update(Lecture lecture) {
        return super.Update(lecture);
    }

    @Override
    public void Delete(Long id) {
        super.Delete(id);
    }

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
}
