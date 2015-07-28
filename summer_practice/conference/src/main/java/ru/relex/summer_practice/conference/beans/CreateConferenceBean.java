package ru.relex.summer_practice.conference.beans;

import org.primefaces.event.FlowEvent;
import ru.relex.summer_practice.db.Conference;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Eugene on 28.07.2015.
 */
@Named
@ViewScoped
public class CreateConferenceBean {
    private List<Conference> conferences;

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    public void btnAddAction(ActionEvent actionEvent) {

    }

    public void save() {
    }

    public String onFlowProcess(FlowEvent event) {
        return "confirm";
    }
}
