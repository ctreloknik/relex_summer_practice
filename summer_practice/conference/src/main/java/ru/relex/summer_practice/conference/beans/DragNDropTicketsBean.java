package ru.relex.summer_practice.conference.beans;

import org.primefaces.event.DragDropEvent;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Ticket;
import ru.relex.summer_practice.service.ConferenceService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nikita on 18.07.2015.
 */

@Named
@ViewScoped
public class DragNDropTicketsBean implements Serializable {

    @EJB
    ConferenceService conferenceService;

    private List<Conference> conferences;

    @PostConstruct
    public void init() {
        conferences = conferenceService.getTicketsForBuying();
    }

    public void onTicketDrop(DragDropEvent ddEvent) {
        Ticket ticket = ((Ticket) ddEvent.getData());

    }

    public void setService(ConferenceService service) {
        this.conferenceService = service;
    }

    public List<Conference> getTickets() {
        return conferences;
    }

}
