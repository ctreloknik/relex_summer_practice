package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;
import ru.relex.summer_practice.db.Ticket;

import java.util.Collection;

/**
 * Created by Nikita on 12.07.2015.
 */
public interface PersonTicketDao extends GenericCrudDao<PersonTicket, Long> {
    public Collection getTicketsByPerson(Person person);
    public Collection getPersonsByTickets(Ticket ticket);
}
