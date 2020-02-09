package edu.tusur.kp.jpa.dto;

import edu.tusur.kp.jpa.model.Person;
import edu.tusur.kp.jpa.model.Restriction;
import java.util.Date;
import java.util.List;

public class AccountDto {

    private Long id;
    private Boolean active;
    private Date created;
    private List<Restriction> restriction;
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

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", active=" + active +
                ", created=" + created +
                ", restriction=" + restriction +
                ", person=" + person +
                '}';
    }
}
