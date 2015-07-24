package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.PersonLectureRole;
import ru.relex.summer_practice.service.PersonLectureRoleService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
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

    //@EJB
    //LectureService lectureService;

    private List<PersonLectureRole> roles;

    @PostConstruct
    public void init() {
        roles = service.ReadAll();
    }

    public List<PersonLectureRole> getRoles() {
        return roles;
    }
}
