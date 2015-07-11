package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Person;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface PersonDao extends GenericCridDao<Person, Long>{
    public Person Create(String fullName, String phoneNumber, String email, String login, String password);
}
