package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonDao;
import ru.relex.summer_practice.db.Person;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public class PersonDaoImpl extends GenericCrudDaoImpl<Person, Long> implements PersonDao {
    public PersonDaoImpl(){
        super(Person.class);
    }

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

    public Person getUserByNickname(String login) {
        String jpa = "SELECT p FROM Person p WHERE p.login = :login";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("login",login);
        return this.EexecuteQuery(jpa, parameters).get(0);
    }
}
