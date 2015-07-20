package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonLectureRole;
import ru.relex.summer_practice.db.Roles;

import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public interface PersonLectureRoleDao extends GenericCrudDao<PersonLectureRole, Long> {
    public List<PersonLectureRole> getAllByPerson(Person person);
    public List<PersonLectureRole> getAllByLecture(Lecture lecture);
    public List<PersonLectureRole> getAllByRoles(Roles roles);

}
