package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;
import ru.relex.summer_practice.service.PersonService;
import ru.relex.summer_practice.service.PersonTicketService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Nikita on 19.07.2015.
 */

@Named
@ViewScoped
public class PersonTicketBean {

    @EJB
    PersonTicketService service;

    @EJB
    PersonService personService;

    @PostConstruct
    public void init() {}

    private List<PersonTicket> personTickets;

    public List<PersonTicket> getTickets(String login) {
        personTickets = service.getTicketsByPerson(getPerson(login));
        return personTickets;
    }

    public void setService(PersonTicketService service) {
        this.service = service;
    }

    public Person getPerson(String login){
        return personService.getUserByNickname(login);
    }

}
