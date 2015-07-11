package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "Lecture")
public class Lecture {
    @Id
    @Column(name = "LectureID")
    @GeneratedValue()
    private Long id;

    //CourseID

    @Column(name = "Topic")
    private String topic;

    @Column(name = "Datetime")
    private Date datetime;

    @Column(name = "Description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
