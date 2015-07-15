package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonLectureRoleDao;
import ru.relex.summer_practice.db.PersonLectureRole;

/**
 * Created by Nikita on 12.07.2015.
 */
public class PersonLectureRoleDaoImpl extends GenericCrudDaoImpl<PersonLectureRole, Long> implements PersonLectureRoleDao {
    public PersonLectureRoleDaoImpl(){
        super(PersonLectureRole.class);
    }
}
