package com.example.springtest.Entity;

import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "NID",  unique = true)
    private String NID;
    @Column(name = "BDate")
    private LocalDate birthOrEstablishDate;
    @Column(name = "type")
    private CustomerType customerType;
    @Column(name = "mobile",   unique = true)
    private String mobileNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "postal")
    private String postalCode;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    public User(String name, String NID, LocalDate birthOrEstablishDate, CustomerType customerType, String mobileNumber, String address, String postalCode, Account account) {
        this.name = name;
        this.NID = NID;
        this.birthOrEstablishDate = birthOrEstablishDate;
        this.customerType = customerType;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.account = account;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public LocalDate getBirthOrEstablishDate() {
        return birthOrEstablishDate;
    }

    public void setBirthOrEstablishDate(LocalDate birthOrEstablishDate) {
        this.birthOrEstablishDate = birthOrEstablishDate;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
