package ru.relex.summer_practice.db;

/**
 * Created by Nikita on 11.07.2015.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="TICKET")
public class Ticket {
    public Ticket() {}

    @Id
    @Column(name="TICKET_ID")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CONFERENCE_ID")
    private Conference conference;

    @Column(name = "PRICE")
    private int price;

    //
    @OneToMany(mappedBy = "ticket")
    private transient Set<PersonTicket> personTicket = new HashSet<PersonTicket>();

    public Set<PersonTicket> getPersonTicket() {
        return personTicket;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
