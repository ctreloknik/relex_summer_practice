package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Course;

import java.util.Date;
import java.util.List;

/**
 * Created by Eugene on 12.07.2015.
 */
public interface CourseDao extends GenericCrudDao<Course, Long> {
    public Date getStartDate(Course course);
    public Date getEndDate(Course course);
    public Course getCourseById (Long id);
    public List<Course> getNexEvents();
    public List<Course> getCourseByConferenceId (Long id);
}
