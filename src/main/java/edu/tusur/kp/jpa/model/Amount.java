package edu.tusur.kp.jpa.model;

import javax.persistence.*;

@Entity
public class Amount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "debt")
    private Long debt;

    @Column(name = "balance")
    private Long balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deposit")
    private Deposit deposit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account")
    private Account account;

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

    public Long getDebt() {
        return debt;
    }

    public void setDebt(Long debt) {
        this.debt = debt;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
