package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.PersonLectureRoleDaoImpl;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonLectureRole;
import ru.relex.summer_practice.db.Roles;

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

// Need

@Stateless
public class PersonLectureRoleService extends PersonLectureRoleDaoImpl{

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
    public PersonLectureRole Create(PersonLectureRole personLectureRole) {
        return super.Create(personLectureRole);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public PersonLectureRole Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<PersonLectureRole> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public PersonLectureRole Update(PersonLectureRole personLectureRole) {
        return super.Update(personLectureRole);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<PersonLectureRole> getAllByPerson(Person person) {
        return super.getAllByPerson(person);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<PersonLectureRole> getAllByLecture(Lecture lecture) {
        return super.getAllByLecture(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<PersonLectureRole> getAllByRoles(Roles roles) {
        return super.getAllByRoles(roles);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<PersonLectureRole> EexecuteQuery(String jpql, Map<String, Object> parametres) {
        return super.EexecuteQuery(jpql, parametres);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected List<PersonLectureRole> EexecuteQuery(String jpql) {
        return super.EexecuteQuery(jpql);
    }
}
