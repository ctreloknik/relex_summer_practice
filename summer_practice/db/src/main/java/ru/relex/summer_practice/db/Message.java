package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sasha on 11.07.2015.
 */

@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATETIME")
    private Date datetime;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
