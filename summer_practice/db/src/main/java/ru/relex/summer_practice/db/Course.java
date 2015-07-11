package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue()
    @Column(name = "COURSE_ID")
    private Long id;

    // Одному конкретному потоку соответсвует одна конкретная конференция
    @ManyToOne
    @JoinColumn(name = "CONFERENCE_ID")
    private Conference conference;

    // Одному конкретному потоку соответсвует одна конкретная аудитория
    @ManyToOne
    @JoinColumn(name = "LECTUREROOM_ID")
    private LectureRoom lectureRoom;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "STARTDATE")
    private Date startDate;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "ENDDATE")
    private Date endDate;

    // Одному потоку соответсвует множество лекций
    @OneToMany(mappedBy = "course")
    private Set<Lecture> lectures = new HashSet<Lecture>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public LectureRoom getLectureRoom() {
        return lectureRoom;
    }

    public void setLectureRoom(LectureRoom lectureRoom) {
        this.lectureRoom = lectureRoom;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }
}
