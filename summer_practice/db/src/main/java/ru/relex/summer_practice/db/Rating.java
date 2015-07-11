package ru.relex.summer_practice.db;

import javax.persistence.*;

/**
 * Created by Sasha on 11.07.2015.
 */

@Entity
@Table(name = "RATING")
public class Rating {
    @Id
    @GeneratedValue
    @Column(name = "RATING_ID")
    private Long id;

    @Column(name = "RATING")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
