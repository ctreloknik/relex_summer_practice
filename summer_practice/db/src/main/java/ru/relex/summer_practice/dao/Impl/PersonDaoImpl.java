package ru.relex.summer_practice.dao.Impl;

import ru.relex.summer_practice.dao.PersonDao;
import ru.relex.summer_practice.db.Person;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sasha on 12.07.2015.
 */
public class PersonDaoImpl extends GenericCrudDaoImpl<Person, Long> implements PersonDao {
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

    public PersonDaoImpl(){
        super(Person.class);
    }

    public Person getUserByNickname(String login) {
        String jpa = "SELECT p FROM Person p WHERE p.login = :login";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("login",login);
        List<Person> person = this.EexecuteQuery(jpa,parameters);
        if (person.size() != 1){
            return null;
        }
        return person.get(0);
    }

    @Override
    public Person getUserByEmail(String email) {
        String jpa = "SELECT p FROM Person p WHERE p.email = :email";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("email",email);
        List<Person> person = this.EexecuteQuery(jpa,parameters);
        if (person.size() != 1){
            return null;
        }
        return person.get(0);
    }

    @Override
    public Person getUserById(Long id) {
        String jpa = "SELECT p FROM Person p WHERE p.id = :id";
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("id",id);
        List<Person> person = this.EexecuteQuery(jpa,parameters);
        if (person.size() != 1){
            return null;
        }
        return person.get(0);
    }
}
