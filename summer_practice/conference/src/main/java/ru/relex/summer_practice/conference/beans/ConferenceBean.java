package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Course;
import ru.relex.summer_practice.service.ConferenceService;
import ru.relex.summer_practice.service.CourseService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Eugene on 22.07.2015.
 */
@Named
@SessionScoped
public class ConferenceBean implements Serializable {

    @EJB
    ConferenceService conferenceService;

    @EJB
    CourseService courseService;

    @PostConstruct
    public void initConferenceBean() {
    }

    private Conference conference;

    public String Detail() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(params.get("conferenceId"));
        conference = conferenceService.getConferenceById(id);
        conference.setCourses(new HashSet<Course>(courseService.getCourseByConferenceId(conference.getId())));
        return "success";
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
