package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita on 11.07.2015.
 */

@Entity
@Table(name = "PERSON_TICKET")
public class PersonTicket {
    public PersonTicket() {}

    @Id
    @Column(name = "PERSON_TICKET_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;


    // доклады для людей
    @OneToMany(mappedBy = "personTicket")
    private transient Set<LecturePerson> lecturePerson = new HashSet<LecturePerson>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Long getId() {

        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Set<LecturePerson> getLecturePerson() {
        return lecturePerson;
    }
}
