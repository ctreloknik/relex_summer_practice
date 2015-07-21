package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "CONFERENCE")
public class Conference {
    @Id
    @GeneratedValue
    @Column(name = "CONFERENCE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;// Название конференции

    @Column(name = "DESCRIPTION")
    private String description;// Описание конференции

    @Column(name = "MODERATED")
    private Boolean moderated;

    @OneToMany(mappedBy = "conference")
    private transient Set<Course> courses = new HashSet<Course>();

    @OneToMany(mappedBy = "conference")
    private transient Set<Ticket> ticket = new HashSet<Ticket>();

    @OneToMany(mappedBy = "conference")
    private transient Set<Founders> founders = new HashSet<Founders>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getModerated() {
        return moderated;
    }

    public void setModerated(Boolean moderated) {
        this.moderated = moderated;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(Set<Ticket> ticket) {
        this.ticket = ticket;
    }

    public Set<Founders> getFounders() {
        return founders;
    }

    public void setFounders(Set<Founders> founders) {
        this.founders = founders;
    }
}
