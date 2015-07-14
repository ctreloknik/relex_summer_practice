package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.LectureRoomDao;
import ru.relex.summer_practice.db.LectureRoom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Eugene on 12.07.2015.
 */
public class LectureRoomDaoImpl extends GenericCrudDaoImpl<LectureRoom, Long> implements LectureRoomDao {
    public LectureRoomDaoImpl() {
        super(LectureRoom.class);
    }

    public String getNumber(LectureRoom lectureRoom) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long lectureRoom_id = lectureRoom.getId();
            return em.find(LectureRoom.class, lectureRoom_id).getNumber();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

    public int getSeating(LectureRoom lectureRoom) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
            em = emf.createEntityManager();
            Long lectureRoom_id = lectureRoom.getId();
            return em.find(LectureRoom.class, lectureRoom_id).getSeating();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
