package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sasha on 16.07.2015.
 */

@Named
@ViewScoped
public class PersonsBean implements Serializable {

    @EJB
    PersonService personService;

    private Person currentPerson;

    @PostConstruct
    public void initPersonsBean() {
        currentPerson = getPerson(getCurrentUser());
    }

    private List<Person> persons;

    public List<Person> getPersons() {
        persons = personService.ReadAll();
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    private Person getPerson(String login) {
        return personService.getUserByNickname(login);
    }

    private String getCurrentUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext externalContext = fc.getExternalContext();
        return externalContext.getUserPrincipal().getName();
    }

    public void updatePerson(){
        personService.Update(currentPerson);
    }
}
