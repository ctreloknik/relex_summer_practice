package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sasha on 11.07.2015.
 */

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person questioner;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DATETIME")
    private Date datetime;

    @Column(name = "MODERATED")
    private boolean Moderated;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    @OneToMany(mappedBy = "question")
    private transient Set<Rating> ratings = new HashSet<Rating>();

    public boolean getModerated() {
        return Moderated;
    }

    public void setModerated(boolean moderated) {
        Moderated = moderated;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getQuestioner() {
        return questioner;
    }

    public void setQuestioner(Person questioner) {
        this.questioner = questioner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public boolean isModerated() {
        return Moderated;
    }

        public Set<Rating> getRatings() {
        return ratings;
    }
}
