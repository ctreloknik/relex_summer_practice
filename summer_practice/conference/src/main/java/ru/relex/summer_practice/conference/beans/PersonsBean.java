package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sasha on 16.07.2015.
 */

@Named
@SessionScoped
public class PersonsBean implements Serializable {

    @EJB
    PersonService personService;

    @PostConstruct
    public void initPersonsBean(){

    }

    private List<Person> persons;

    public List<Person> getPersons() {
        persons = personService.ReadAll();
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
