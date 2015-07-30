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

    private List<Course> detailedCourses;

    private Course nextEvent;

    private ScheduleModel lazyEventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private boolean isEmptyNextEvents = false;

    @PostConstruct
    public void init(){
        courses = courseService.ReadAll();
        List<Course> nextEventsTmp = courseService.getNexEvents();

        if(nextEventsTmp.size() != 0) {
            isEmptyNextEvents = true;
            nextEvent = nextEventsTmp.get(0);
        }
        else isEmptyNextEvents = false;

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

    public Course getNextEvent() {
        return nextEvent;
    }

    public boolean getIsEmpty(){
        return this.isEmptyNextEvents;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public List<Course> getDatailedCources(){
        return detailedCourses;
    }

    public void onDateSelect(SelectEvent selectEvent) {
        System.out.println(" !!!DATE " + ((Date)selectEvent.getObject()));
        detailedCourses = courseService.getCourcesBydate(((Date)selectEvent.getObject()));
        System.out.println(" !!!COUNT " + courseService.getCourcesBydate(((Date)selectEvent.getObject())).size());
    }

}
