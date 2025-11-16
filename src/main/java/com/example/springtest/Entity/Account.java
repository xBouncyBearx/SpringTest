package com.example.springtest.Entity;

import com.example.springtest.Entity.Enum.AccountStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(name = "AID",  unique = true)
    private String AID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "status")
    private AccountStatus accountStatus;

    @Column(name = "username",  unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private Double balance;

    public Account(String AID, User user, AccountStatus accountStatus, String username, String password,  Double balance) {
        this.AID = AID;
        this.user = user;
        this.accountStatus = accountStatus;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Account() {
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
