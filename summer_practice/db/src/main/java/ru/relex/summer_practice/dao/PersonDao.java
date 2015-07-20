package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.db.Person;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface PersonDao extends GenericCrudDao<Person, Long> {
    public Person Login(String login, String password);
    public Person getUserByNickname(String login);
}
