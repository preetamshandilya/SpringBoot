package com.example.auth.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String name;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)

    private List<BankDetails> bankDetailsList=new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)

    private List<LocationDetails> locationDetailsList;

    public List<LocationDetails> getLocationDetailsList() {
        return locationDetailsList;
    }

    public void setLocationDetailsList(List<LocationDetails> locationDetailsList) {
        this.locationDetailsList = locationDetailsList;
    }

    private String emailId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mobNo;
    private int age;
    private String sex;
    private String status;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String name, List<BankDetails> bankDetailsList, List<LocationDetails> locationDetailsList, String emailId, long mobNo, int age, String sex, String status, LocalDateTime createdAt, LocalDateTime updatedAt, String password) {
        this.id = id;
        this.name = name;
        this.bankDetailsList = bankDetailsList;
        this.locationDetailsList = locationDetailsList;
        this.emailId = emailId;
        this.mobNo = mobNo;
        this.age = age;
        this.sex = sex;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.password = password;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public List<BankDetails> getBankDetailsList() {
        return bankDetailsList;
    }

    public void setBankDetailsList(List<BankDetails> bankDetailsList) {
        this.bankDetailsList = bankDetailsList;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobNo() {
        return mobNo;
    }

    public void setMobNo(long mobNo) {
        this.mobNo = mobNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }


}

