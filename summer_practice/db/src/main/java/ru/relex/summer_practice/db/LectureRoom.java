package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "LECTURE_ROOM")
public class LectureRoom {
    @Id
    @GeneratedValue
    @Column(name = "LECTURE_ROOM_ID")
    private Long id;

    @Column(name = "NUMBER")
    private String number;// Номер аудитории

    @Column(name = "SEATING")
    private Integer seating;// Число мест для сидения

    // Одной аудитории соответсвует много потоков в разное время
    @OneToMany(mappedBy = "lectureRoom")
    private Set<Course> courses = new HashSet<Course>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getSeating() {
        return seating;
    }

    public void setSeating(Integer seating) {
        this.seating = seating;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
