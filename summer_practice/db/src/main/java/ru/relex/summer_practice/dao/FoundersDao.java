package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Founders;
import ru.relex.summer_practice.db.Person;

import java.util.Collection;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface FoundersDao extends GenericCrudDao<Founders, Long> {
    public Collection getConferensesByPerson(Person person);
    public Collection getPersonsByConference(Conference conference);
}
