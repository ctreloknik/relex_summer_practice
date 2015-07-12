package ru.relex.summer_practice.db;

import javax.persistence.*;

/**
 * Created by Nikita on 11.07.2015.
 */

@Entity
@Table(name = "FOUNDERS")
public class Founders {
    public Founders() {}

    @Id
    @Column(name = "FOUNDERS_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "CONFERENCE_ID")
    private Conference conference;

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

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
