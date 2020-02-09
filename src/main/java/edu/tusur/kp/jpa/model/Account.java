package edu.tusur.kp.jpa.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean active;

    @CreatedDate
    private Date created;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Restriction> restriction;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Restriction> getRestriction() {
        return restriction;
    }

    public void setRestriction(List<Restriction> restriction) {
        this.restriction = restriction;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
