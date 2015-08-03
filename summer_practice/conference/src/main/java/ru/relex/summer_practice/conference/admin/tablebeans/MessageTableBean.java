package ru.relex.summer_practice.conference.admin.tablebeans;

import ru.relex.summer_practice.conference.admin.annotations.EntityField;
import ru.relex.summer_practice.conference.admin.annotations.SelectOne;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Message;
import ru.relex.summer_practice.service.LectureService;
import ru.relex.summer_practice.service.MessageService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sasha on 30.07.2015.
 */
@SessionScoped
@ManagedBean(name = "messageTableBean")
public class MessageTableBean extends AbstractTableBean {

    @EJB
    MessageService messageService;
    @EJB
    LectureService lectureService;

    @EntityField
    Message message;

    @SelectOne(field = "lecture")
    private Map<String, Lecture> lectures;

    @PostConstruct
    public void init(){
        this.setService(messageService);
        lectures = new HashMap<String,Lecture>();
        for (Lecture lecture : lectureService.ReadAll()){
            lectures.put(lecture.getId().toString(),lecture);
        }
    }

    private transient Long lecid;

    public Long getLecid() {
        return lecid;
    }

    public void setLecid(Long lecid) {
        this.lecid = lecid;
    }

    public Map<String, Lecture> getLectures() {
        return lectures;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
