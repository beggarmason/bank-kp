package edu.tusur.kp.jpa.dto;

import edu.tusur.kp.jpa.model.*;

import java.util.Date;
import java.util.List;

public class DepositDto {

    private Long id;
    private String name;
    private String currency;
    private Integer year;
    private Date fromDate;
    private Date toDate;
    private Person person;
    private Long personid;
    private Plan plan;
    private Long planid;
    private Type type;
    private Long typeid;
    private List<Restriction> restriction;
    private Bonus bonus;
    private Long bonusid;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Long getPlanid() {
        return planid;
    }

    public void setPlanid(Long planid) {
        this.planid = planid;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
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

    public Long getBonusid() {
        return bonusid;
    }

    public void setBonusid(Long bonusid) {
        this.bonusid = bonusid;
    }

    @Override
    public String toString() {
        return "DepositDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", year=" + year +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", person=" + person +
                ", personid=" + personid +
                ", plan=" + plan +
                ", planid=" + planid +
                ", type=" + type +
                ", typeid=" + typeid +
                ", restriction=" + restriction +
                ", bonus=" + bonus +
                ", bonusid=" + bonusid +
                '}';
    }
}
