package edu.tusur.kp.jpa.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean active;

    @CreatedDate
    private Date created;

    @OneToMany
    private List<Account> account;

    @OneToMany
    private List<Deposit> deposit;

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

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public List<Deposit> getDeposit() {
        return deposit;
    }

    public void setDeposit(List<Deposit> deposit) {
        this.deposit = deposit;
    }
}
