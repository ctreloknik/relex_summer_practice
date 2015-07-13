package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonDao;
import ru.relex.summer_practice.db.Person;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public class PersonDaoImplImpl extends GenericCrudDaoImplImpl<Person, Long> implements PersonDao {
    public Person Login(String login, String password) {
        String jpa = "SELECT p FROM Person p WHERE p.login = :login and p.password = :password";
        HashMap<String,Object> parametres = new HashMap<>();
        parametres.put("login", login);
        parametres.put("password", password);
        List<Person> person = this.EexecuteQuery(jpa,parametres);
        if (person.size() != 1){
            return null;
        }
        return person.get(0);
    }
}
