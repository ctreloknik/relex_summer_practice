package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "LectureRoom")
public class LectureRoom {
    @Id
    @Column(name = "LectureRoomID")
    @GeneratedValue
    private Long id;

    @Column(name = "Number")
    private String number;// Номер аудитории

    @Column(name = "Seating")
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
}
