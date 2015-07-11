package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eugene on 11.07.2015.
 */
@Entity
@Table(name = "Conference")
public class Conference {
    @Id
    @Column(name = "ConferenceID")
    @GeneratedValue
    private Long id;

    @Column(name = "Name")
    private String name;// Название конференции

    @Column(name = "Description")
    private String description;// Описание конференции

    // Одной конференции соответсвует множество потоков
    @OneToMany(mappedBy = "conference")
    private Set<Course> course = new HashSet<Course>();

    // Одной конференции соответсвует множество билетов
    @OneToMany(mappedBy = "conference")
    private Set<Ticket> ticket = new HashSet<Ticket>();

    @OneToMany(mappedBy = "conference")
    private Set<Founders> founders = new HashSet<Founders>();

    public Set<Course> getCourse() {
        return course;
    }

    public Set<Ticket> getTicket() {

        return ticket;
    }

    public Set<Founders> getFounders() {
        return founders;
    }

    public Set<Ticket> getTickets() {
        return ticket;
    }

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
}
