package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.PersonLectureRole;
import ru.relex.summer_practice.service.PersonLectureRoleService;
import ru.relex.summer_practice.service.PersonService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Nikita on 22.07.2015.
 */

@Named
@ViewScoped
public class RolesOnLecturesBean {

    @EJB
    PersonLectureRoleService service;

    @EJB
    PersonService personService;

    //@EJB
    //LectureService lectureService;

    private List<PersonLectureRole> roles;

    @PostConstruct
    public void init() {
        roles = service.getAllByPerson(getPerson(getCurrentUser()));
    }

    public List<PersonLectureRole> getRoles() {
        return roles;
    }

    private Person getPerson(String login){
        return personService.getUserByNickname(login);
    }

    private String getCurrentUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext externalContext = fc.getExternalContext();
        return externalContext.getUserPrincipal().getName();
    }
}
