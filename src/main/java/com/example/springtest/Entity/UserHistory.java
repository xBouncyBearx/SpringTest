package com.example.springtest.Entity;

import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.Enum.CustomerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "history")
public class UserHistory extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "NID")
    private String NID;
    @Column(name = "BDate")
    private LocalDate birthOrEstablishDate;
    @Column(name = "type")
    private CustomerType customerType;
    @Column(name = "mobile")
    private String mobileNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "postal")
    private String postalCode;
    @Column(name = "status")
    private AccountStatus accountStatus;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public UserHistory(String name, String NID, LocalDate birthOrEstablishDate, CustomerType customerType, String mobileNumber, String address, String postalCode, AccountStatus accountStatus, String username, String password) {
        this.name = name;
        this.NID = NID;
        this.birthOrEstablishDate = birthOrEstablishDate;
        this.customerType = customerType;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.accountStatus = accountStatus;
        this.username = username;
        this.password = password;
    }

    public UserHistory() {}

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
}
