package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonDao;
import ru.relex.summer_practice.db.Person;

/**
 * Created by Sasha on 12.07.2015.
 */
public class PersonDaoImpl extends GenericCrudDaoImpl<Person, Long> implements PersonDao{
    public Person Create(String fullName, String phoneNumber, String email, String login, String password){
        return super.Create(new Person(fullName,phoneNumber,email,login,password));
    }
}
