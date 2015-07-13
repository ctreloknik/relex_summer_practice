package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "LECTURE")
public class Lecture {
    @Id
    @Column(name = "LECTURE_ID")
    @GeneratedValue()
    private Long id;

    // Одной конкретной лекции соответсвует один конкретный поток
    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @Column(name = "TOPIC")
    private String topic;

    @Column(name = "DATETIME")
    private Date datetime;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "lecture")
    private Set<Question> question = new HashSet<Question>();

    // доклады - люди
    @OneToMany(mappedBy = "lecture")
    private Set<LecturePerson> lecturePerson = new HashSet<LecturePerson>();

    @OneToMany(mappedBy = "lecture")
    private Set<Message> message = new HashSet<Message>();

    public Set<LecturePerson> getLecturePerson() {
        return lecturePerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Message> getMessages() {
        return message;

    }

    public Set<Question> getQuestion(){
        return question;
    }
}
