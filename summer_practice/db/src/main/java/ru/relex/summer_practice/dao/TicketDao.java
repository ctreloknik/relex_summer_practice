package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Ticket;

/**
 * Created by Nikita on 12.07.2015.
 */
public interface TicketDao extends GenericCrudDao<Ticket, Long>{
    public Ticket Create (Long conference_id, int price);
    public Ticket Read (Long ID);
    public Ticket Update (Long conference_id, int price);
    public void Delete(Ticket ticket);
}
