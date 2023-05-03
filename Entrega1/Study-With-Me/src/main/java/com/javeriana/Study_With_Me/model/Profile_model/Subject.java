package com.javeriana.Study_With_Me.model.Profile_model;

import java.io.Serializable;

public class Subject implements Serializable {
    private String id;
    private String name;
    private String credits;
    private String skill;

    public Subject(String id, String name, String credits, String skill) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.skill = skill;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}