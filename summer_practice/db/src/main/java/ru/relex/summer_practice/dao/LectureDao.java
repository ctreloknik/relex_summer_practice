package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Question;

import java.util.Date;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface LectureDao extends GenericCrudDao<Lecture, Long> {
    public String getTopic(Lecture lecture);
    public Date getDatetime(Lecture lecture);
    public String getDescription(Lecture lecture);
    public Date getStartTimeByCourse(Course course);
    public Lecture getLectureByID(Long lectureID);
    public List<Lecture> getLectureByCourseId(Long id);
}
