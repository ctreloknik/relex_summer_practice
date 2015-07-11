package ru.relex.summer_practice.dao;

import ru.relex.summer_practice.dao.GenericDaoCrud;
import ru.relex.summer_practice.db.Person;

/**
 * Created by Sasha on 11.07.2015.
 */
public class PersonDao extends GenericDaoCrud<Person, Long> {

    public Person Create(String fullName, String phoneNumber, String email, String login, String password){
        return super.Create(new Person(fullName,phoneNumber,email,login,password));
    }
}
