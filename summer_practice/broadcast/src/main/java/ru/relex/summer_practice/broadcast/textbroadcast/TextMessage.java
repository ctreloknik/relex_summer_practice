package ru.relex.summer_practice.broadcast.textbroadcast;

import java.util.Date;

/**
 * Created by Sasha on 26.07.2015.
 */
public class TextMessage {

    private Long person;
    private Long question;
    private Long lecture;
    private String text;
    private int rating;
    private Date datetime;
    private String type;
    private String name;

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Long getLecture() {
        return lecture;
    }

    public void setLecture(Long lecture) {
        this.lecture = lecture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuestion() {
        return question;
    }

    public void setQuestion(Long question) {
        this.question = question;
    }
}
