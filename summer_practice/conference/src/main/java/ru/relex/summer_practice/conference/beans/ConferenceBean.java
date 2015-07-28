package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.service.ConferenceService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by Eugene on 22.07.2015.
 */
@Named
@SessionScoped
public class ConferenceBean implements Serializable {

    @EJB
    ConferenceService conferenceService;

    @PostConstruct
    public void initConferenceBean() {
    }

    private Conference conference;

    public String Detail() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        Long id = Long.parseLong(params.get("conferenceId"));
        conference = conferenceService.getConferenceById(id);
        return "success";
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
