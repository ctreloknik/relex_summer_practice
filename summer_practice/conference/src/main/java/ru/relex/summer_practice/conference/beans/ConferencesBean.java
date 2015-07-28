package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.service.ConferenceService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Eugene on 22.07.2015.
 */
@Named
@ViewScoped
public class ConferencesBean implements Serializable {

    @EJB
    ConferenceService conferenceService;

    @PostConstruct
    public void initConferencesBean() {
    }

    private List<Conference> conferences;

    public List<Conference> getConferences() {
        return conferenceService.getModeratedConference(true);
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }
}
