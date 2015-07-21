package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.LecturePersonDaoImpl;
import ru.relex.summer_practice.db.LecturePerson;

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
public class LecturePersonService extends LecturePersonDaoImpl{

    @Override
    protected void closeEntityManager() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public LecturePerson Create(LecturePerson lecturePerson) {
        return super.Create(lecturePerson);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public LecturePerson Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<LecturePerson> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public LecturePerson Update(LecturePerson lecturePerson) {
        return super.Update(lecturePerson);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<LecturePerson> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<LecturePerson> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
