package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonTicket;

import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public interface PersonTicketDao extends GenericCrudDao<PersonTicket, Long> {
    public List<PersonTicket> getTicketsByPerson(Person person);
    //public List<PersonTicket> getPersonsByTickets(Ticket ticket);
    public List<PersonTicket> getPersonsByTickets(Conference conference);
}
