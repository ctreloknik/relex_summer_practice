package ru.relex.summer_practice.dao;


import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.LecturePerson;
import ru.relex.summer_practice.db.Person;

import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface LecturePersonDao extends GenericCrudDao<LecturePerson, Long> {
    public List<LecturePerson> getPersonByLecture(Lecture lecture);
    public List<LecturePerson> getLecturesByPerson(Person person);
}
