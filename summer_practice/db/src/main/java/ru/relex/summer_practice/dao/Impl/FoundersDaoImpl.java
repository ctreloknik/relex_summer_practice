package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.FoundersDao;
import ru.relex.summer_practice.db.Conference;
import ru.relex.summer_practice.db.Founders;
import ru.relex.summer_practice.db.Person;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Nikita on 12.07.2015.
 */
public class FoundersDaoImpl extends GenericCrudDaoImpl<Founders, Long> implements FoundersDao {
    public FoundersDaoImpl(){
        super(Founders.class);
    }

    public List<Founders> getConferensesByPerson(Person person) {
        String jpql = "select f from Founders f where f.person = :person";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("person",person);
        return this.EexecuteQuery(jpql, parameters);
    }

    public List<Founders> getPersonsByConference(Conference conference) {
        String jpql = "select f from Founders f where f.conference = :conference";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("conference",conference);
        return this.EexecuteQuery(jpql, parameters);
    }
}
