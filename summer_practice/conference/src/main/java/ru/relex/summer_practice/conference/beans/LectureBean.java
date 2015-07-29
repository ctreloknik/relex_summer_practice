package ru.relex.summer_practice.conference.beans;

import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Person;
import ru.relex.summer_practice.db.Question;
import ru.relex.summer_practice.db.Roles;
import ru.relex.summer_practice.db.Message;
import ru.relex.summer_practice.service.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Sasha on 26.07.2015.
 */

@Named
@SessionScoped
public class LectureBean implements Serializable {

    @EJB
    private PersonService personService;
    @EJB
    private LectureService lectureService;
    @EJB
    private PersonLectureRoleService personLectureRoleService;
    @EJB
    private QuestionService questionService;
    @EJB
    private MessageService messageService;

    private List<Question> questions;
    private List<Message> messages;

    private Person person;
    private Lecture lecture;
    private Roles role;

    @PostConstruct
    public void init() {
        String login = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        person = personService.getUserByNickname(login);
    }

    private Long lectureID;

    public Long getLectureID() {
        return lectureID;
    }

    public void setLectureID(Long lectureID) {
        this.lectureID = lectureID;
    }

    public String goToLecture() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        lectureID = Long.parseLong(params.get("lectureID"));
        lecture = lectureService.getLectureByID(lectureID);
        role = personLectureRoleService.getRoleByPersonLecture(person, lecture);
        questions = questionService.ReadQuestionByLecture(lecture);
        messages = messageService.ReadAllByLecture(lecture);
        return "success";
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}

