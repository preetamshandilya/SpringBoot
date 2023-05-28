package com.example.FreelancerFinder.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "freelancers")

public class Freelancer {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public long getCharges() {
        return charges;
    }

    public void setCharges(long charges) {
        this.charges = charges;
    }

    public Freelancer() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    private String name;


    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public Freelancer(int id, String name, String techStack, long charges) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
        this.charges = charges;
    }
    private String techStack;

    private long charges;

}
