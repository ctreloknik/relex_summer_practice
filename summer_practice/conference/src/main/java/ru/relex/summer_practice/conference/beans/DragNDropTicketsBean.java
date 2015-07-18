package ru.relex.summer_practice.conference.beans;

import org.primefaces.event.DragDropEvent;
import ru.relex.summer_practice.db.Ticket;
import ru.relex.summer_practice.service.TicketService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita on 18.07.2015.
 */

@Named
@ViewScoped
public class DragNDropTicketsBean implements Serializable {

    @EJB
    TicketService ticketService;

    private List<Ticket> tickets;
    private List<Ticket> droppedTickets;

    private Ticket selectedTicket;

    @PostConstruct
    public void init(){
        tickets = ticketService.ReadAll();
        droppedTickets = new ArrayList<Ticket>();
    }
    public void onTicketDrop(DragDropEvent ddEvent) {
        Ticket ticket = ((Ticket) ddEvent.getData());

        droppedTickets.add(ticket);
        tickets.remove(ticket);
    }

    public void setService(TicketService service) {
        this.ticketService = service;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Ticket> getDroppedTickets() {
        return droppedTickets;
    }

    public Ticket getSelectedTicket() {
        return selectedTicket;
    }

    public void setSelectedTicket(Ticket selectedCar) {
        this.selectedTicket = selectedCar;
    }
}
