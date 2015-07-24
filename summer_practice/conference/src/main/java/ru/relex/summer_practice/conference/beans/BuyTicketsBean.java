package ru.relex.summer_practice.conference.beans;

import org.primefaces.model.DualListModel;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.ConferenceService;
import ru.relex.summer_practice.service.PersonService;
import ru.relex.summer_practice.service.PersonTicketService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 18.07.2015.
 */

@Named
@ViewScoped
public class BuyTicketsBean implements Serializable {

    @EJB
    ConferenceService conferenceService;
    @EJB
    PersonService personService;
    @EJB
    PersonTicketService personTicketService;

    private DualListModel<String> conferencesNames;
    private List<Conference> conferences;

    @PostConstruct
    public void init() {
        List<String> conferencesSource = getConferensesNames();
        List<String> conferencesTarget = new ArrayList<String>();

        conferencesNames = new DualListModel<String>(conferencesSource, conferencesTarget);
    }

    public DualListModel<String> getConferences(){
        return conferencesNames;
    }

    public void setConferences(DualListModel<String> conferences) {
        this.conferencesNames = conferences;
    }

    private List<String> getConferensesNames(){
        conferences = conferenceService.getTicketsForBuying(getPerson(getCurrentUser()));
        List<String> result = new ArrayList<String>();

        for (Conference conference : conferences)
            result.add(conference.getId() + " " + conference.getName());
        return result;
    }

    public Person getPerson(String login){
        return personService.getUserByNickname(login);
    }

    public String getCurrentUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext externalContext = fc.getExternalContext();
        return externalContext.getUserPrincipal().getName();
    }

}
