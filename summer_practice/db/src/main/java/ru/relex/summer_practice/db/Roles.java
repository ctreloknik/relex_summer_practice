package ru.relex.summer_practice.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita on 11.07.2015.
 */

@Entity
@Table(name = "ROLES")
public class Roles {
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    //
    @OneToMany(mappedBy = "roles")
    private Set<PersonLectureRole> personLectureRole = new HashSet<PersonLectureRole>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Set<PersonLectureRole> getPersonLectureRole() {
        return personLectureRole;
    }
}
