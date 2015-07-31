package ru.relex.summer_practice.conference.admin.tablebeans;

import ru.relex.summer_practice.conference.admin.annotations.EntityField;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.service.PersonService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ejb.EJB;

/**
 * Created by Sasha on 30.07.2015.
 */

@Named
@SessionScoped
public class PersonTableBean extends AbstractTableBean {

    @EntityField
    private Person person;

    @EJB
    private PersonService personService;

    @PostConstruct
    public void init(){
        this.setService(personService);
    }
}
