package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.service.ConferenceService;
import ru.relex.summer_practice.service.CourseService;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * Created by Eugene on 29.07.2015.
 */
@Named
@ViewScoped
public class MainPageBean {

    @EJB
    ConferenceService conferenceService;

    private Conference conference;

    public Conference getConference() {
        return conferenceService.getModeratedConference(true).get(0);
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
