package ru.relex.summer_practice.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Ticket")
public class Ticket {
    private Long id;
    private Long conferenceId;
    private int price;

    @Id
    @Column(name="TicketID")
    public Long getId() {
        return id;
    }

    @Column(name="ConferenceID")
    public Long getConferenceId() {
        return conferenceId;
    }

    @Column(name = "Price")
    public int getPrice() {
        return price;
    }
}
