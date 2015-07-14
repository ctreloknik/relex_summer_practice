package ru.relex.summer_practice.web.service;

import ru.relex.summer_practice.dao.Impl.LectureRoomDaoImpl;
import ru.relex.summer_practice.db.LectureRoom;

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
public class LectureRoomServise extends LectureRoomDaoImpl{
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
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public String getNumber(LectureRoom lectureRoom) {
        return super.getNumber(lectureRoom);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public int getSeating(LectureRoom lectureRoom) {
        return super.getSeating(lectureRoom);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public LectureRoom Create(LectureRoom lectureRoom) {
        return super.Create(lectureRoom);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public LectureRoom Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<LectureRoom> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public LectureRoom Update(LectureRoom lectureRoom) {
        return super.Update(lectureRoom);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<LectureRoom> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<LectureRoom> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
