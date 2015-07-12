package ru.relex.summer_practice.db;

import javax.persistence.*;

/**
 * Created by Sasha on 12.07.2015.
 */

@Entity
@Table(name = "LECTURE_PERSON")
public class LecturePerson {
    @Id
    @Column(name = "LECTURE_TICKET_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_TICKET_ID")
    private PersonTicket personTicket;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    @Column(name = "PLACE")
    private int place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonTicket getPersonTicket() {
        return personTicket;
    }

    public void setPersonTicket(PersonTicket personTicket) {
        this.personTicket = personTicket;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

}
