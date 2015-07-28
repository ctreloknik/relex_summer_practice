package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonLectureRoleDao;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonLectureRole;
import ru.relex.summer_practice.db.Roles;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public class PersonLectureRoleDaoImpl extends GenericCrudDaoImpl<PersonLectureRole, Long> implements PersonLectureRoleDao {
    public PersonLectureRoleDaoImpl(){
        super(PersonLectureRole.class);
    }

    public List<PersonLectureRole> getAllByPerson(Person person) {
        String jpql = "SELECT plr from PersonLectureRole plr WHERE plr.person = :person";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("person", person);
        return this.EexecuteQuery(jpql, parameters);
    }

    public List<PersonLectureRole> getAllByLecture(Lecture lecture) {
        String jpql = "SELECT plr from PersonLectureRole plr WHERE plr.lecture = :lecture";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("lecture", lecture);
        return this.EexecuteQuery(jpql, parameters);
    }

    public List<PersonLectureRole> getAllByRoles(Roles roles) {
        String jpql = "SELECT plr from PersonLectureRole plr WHERE plr.roles = :roles";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("roles", roles);
        return this.EexecuteQuery(jpql, parameters);
    }

    @Override
    public Roles getRoleByPersonLecture(Person person, Lecture lecture) {
        String jpql = "Select plr from PersonLectureRole plr where plr.person = :person and plr.lecture = :lecture";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("person", person);
        parameters.put("lecture", lecture);
        List<PersonLectureRole> result = this.EexecuteQuery(jpql,parameters);
        if (result.size() != 1){
            return null;
        }
        return result.get(0).getRoles();
    }
}
