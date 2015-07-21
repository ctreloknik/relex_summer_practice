package ru.relex.summer_practice.conference.beans;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.service.CourseService;
import ru.relex.summer_practice.service.LectureService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Nikita on 20.07.2015.
 */

@Named
@ViewScoped
public class EventsViewBean implements Serializable{

    @EJB
    CourseService courseService;

    @EJB
    LectureService lectureService;

    private List<Course> courses;

    private ScheduleModel lazyEventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    @PostConstruct
    public void init(){
        courses = courseService.ReadAll();

        // MAGIC !!!
        lazyEventModel = new LazyScheduleModel(){
            @Override
            public void loadEvents(Date start, Date end){
                for (Course course : courses){
                    addEvent(new DefaultScheduleEvent(course.getConference().getName(),
                            lectureService.getStartTimeByCourse(course), course.getEndDate()));
                }
            }
        };
    }

    public ScheduleModel getLazyEventModel(){
        return lazyEventModel;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

}
