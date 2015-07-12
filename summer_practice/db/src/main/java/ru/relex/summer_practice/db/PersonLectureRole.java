package ru.relex.summer_practice.db;

import javax.persistence.*;

/**
 * Created by Nikita on 11.07.2015.
 */

@Entity
@Table(name = "PERSON_LECTURE_ROLE")
public class PersonLectureRole {
    @Id
    @Column(name = "PERSON_LECTURE_ROLE_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Roles roles;

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

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
