package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonTicketDao;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;
import ru.relex.summer_practice.db.Ticket;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public class PersonTicketDaoImpl extends GenericCrudDaoImpl<PersonTicket, Long> implements PersonTicketDao {
    public PersonTicketDaoImpl(){
        super(PersonTicket.class);
    }

    public List<PersonTicket> getPersonsByTickets(Ticket ticket) {
        String jpql = "SELECT pt from PersonTicket pt WHERE pt.ticket = :ticket";
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("ticket", ticket);
        return this.EexecuteQuery(jpql,parameters);
    }

    public List<PersonTicket> getTicketsByPerson(Person person) {
        String jpql = "SELECT pt from PersonTicket pt WHERE pt.person = :person";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("person", person);
        return this.EexecuteQuery(jpql, parameters);
    }
}
