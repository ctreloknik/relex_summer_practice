package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.LecturePersonDao;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.LecturePerson;
import ru.relex.summer_practice.db.Person;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public class LecturePersonDaoImpl extends GenericCrudDaoImpl<LecturePerson, Long> implements LecturePersonDao {
    public LecturePersonDaoImpl(){
        super(LecturePerson.class);
    }

    public List<LecturePerson> getPersonByLecture(Lecture lecture) {
        String jpql = "SELECT lp from LecturePerson lp WHERE lp.lecture = :lecture";
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("lecture", lecture);
        return this.EexecuteQuery(jpql,parameters);
    }

    public List<LecturePerson> getLecturesByPerson(Person person) {
        String jpql = "SELECT lp from LecturePerson lp WHERE lp.person = :person";
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("person", person);
        return this.EexecuteQuery(jpql,parameters);
    }
}
