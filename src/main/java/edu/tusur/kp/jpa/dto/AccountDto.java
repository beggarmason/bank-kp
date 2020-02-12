package edu.tusur.kp.jpa.dto;

import java.util.Date;
import java.util.List;

public class AccountDto {

    private Long id;
    private Boolean active;
    private String number;
    private Date created;
    private List<RestrictionDto> restriction;
    private PersonDto person;
    private Long personId;

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

    public List<RestrictionDto> getRestriction() {
        return restriction;
    }

    public void setRestriction(List<RestrictionDto> restriction) {
        this.restriction = restriction;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", active=" + active +
                ", number=" + number +
                ", created=" + created +
                ", personId=" + personId +
                ", restriction=" + restriction +
                ", person=" + person +
                '}';
    }
}
