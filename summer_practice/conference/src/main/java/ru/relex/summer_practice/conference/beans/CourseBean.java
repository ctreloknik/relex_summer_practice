package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.service.CourseService;
import ru.relex.summer_practice.service.LectureService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Eugene on 29.07.2015.
 */
@Named
@SessionScoped
public class CourseBean implements Serializable{

    @EJB
    CourseService courseService;

    @EJB
    LectureService lectureService;

    @PostConstruct
    public void initCourseBean() {
    }

    private Course course;

    public String Detail() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(params.get("courseId"));
        course = courseService.getCourseById(id);
        course.setLectures(new HashSet<Lecture>(lectureService.getLectureByCourseId(course.getId())));
        return "success";
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
