package ru.relex.summer_practice.conference.beans;

import org.primefaces.event.DragDropEvent;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;
import ru.relex.summer_practice.service.ConferenceService;
import ru.relex.summer_practice.service.PersonService;
import ru.relex.summer_practice.service.PersonTicketService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class BuyTicketsBean implements Serializable {

    @EJB
    private ConferenceService service;

    @EJB
    private PersonService personService;

    @EJB
    private PersonTicketService personTicketService;

    private List<Conference> conferences;

    private List<Conference> droppedConferences;

    private Conference selectedConference;

    @PostConstruct
    public void init() {
        droppedConferences = new ArrayList<Conference>();
        conferences = service.getTicketsForBuying(getPerson(getCurrentUser()));
    }

    public void onConfDrop(DragDropEvent ddEvent) {
        Conference conference = ((Conference) ddEvent.getData());
        droppedConferences.add(conference);
        conferences.remove(conference);
    }

    public void buyTickets(){
        if (droppedConferences.size() == 0) return;

        PersonTicket personTicket = new PersonTicket();
        Person person = getPerson(getCurrentUser());
        int price = 0;

        for (Conference conference : droppedConferences){
            price += conference.getPrice();
            personTicket.setPerson(person);
            personTicket.setConference(conference);
        }

        if (price <= person.getBalance()) {
            person.setBalance(person.getBalance() - price);
            personTicketService.Create(personTicket);
            personService.Update(person);
        }

        droppedConferences = null;
        init();
        //droppedConferences.clear();
        //conferences = service.getTicketsForBuying(getPerson(getCurrentUser()));
    }

    public void setService(ConferenceService service) {
        this.service = service;
    }

    public List<Conference> getConfs() {
        return conferences;
    }

    public List<Conference> getDroppedConfs() {
        return droppedConferences;
    }

    public Conference getSelectedConfs() {
        return selectedConference;
    }

    public void setSelectedConfs(Conference selectedCar) {
        this.selectedConference = selectedCar;
    }

    private Person getPerson(String login){
        return personService.getUserByNickname(login);
    }

    private String getCurrentUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext externalContext = fc.getExternalContext();
        return externalContext.getUserPrincipal().getName();
    }

}
