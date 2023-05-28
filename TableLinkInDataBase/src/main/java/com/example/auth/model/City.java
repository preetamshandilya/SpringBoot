package com.example.auth.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    public List<LocationDetails> getLocationDetailsList() {
        return locationDetailsList;
    }

    public void setLocationDetailsList(List<LocationDetails> locationDetailsList) {
        this.locationDetailsList = locationDetailsList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(targetEntity = LocationDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private List<LocationDetails> locationDetailsList;


    @ManyToOne()
    @JoinColumn(name = "state_id")
    private State state;

    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public City() {
    }

    public City(int id, List<LocationDetails> locationDetailsList, State state, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.locationDetailsList = locationDetailsList;
        this.state = state;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
