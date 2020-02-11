package edu.tusur.kp.jpa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Deposit {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String currency;

    @Column
    private Integer year;

    @Column
    private Date fromDate;

    @Column
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "person")
    private Person person;

    @OneToOne
    @JoinColumn(name = "plan")
    private Plan plan;

    @OneToOne
    @JoinColumn(name = "type")
    private Type type;

    @OneToMany
    private List<Restriction> restriction;

    @OneToOne
    @JoinColumn(name = "bonus")
    private Bonus bonus;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<Restriction> getRestriction() {
        return restriction;
    }

    public void setRestriction(List<Restriction> restriction) {
        this.restriction = restriction;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
