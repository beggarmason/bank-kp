package edu.tusur.kp.jpa.dto;

import edu.tusur.kp.jpa.model.Account;
import edu.tusur.kp.jpa.model.Deposit;
import java.util.Date;
import java.util.List;

public class BankDto {

    private Long id;
    private String name;
    private Boolean active;
    private Date created;
    private List<Account> account;
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
