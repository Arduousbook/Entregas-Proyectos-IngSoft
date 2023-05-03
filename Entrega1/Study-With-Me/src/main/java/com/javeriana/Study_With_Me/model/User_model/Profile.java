package com.javeriana.Study_With_Me.model.User_model;

import com.javeriana.Study_With_Me.model.Profile_model.Subject;
import com.javeriana.Study_With_Me.model.Profile_model.SubjectCache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class Profile implements Serializable {

    protected String name;
    protected ArrayList<Subject> currentSubjects;

    protected ArrayList <String> aptitudes;

    public Profile(String name, ArrayList<Subject> currentSubjects) {
        this.name = name;
        this.currentSubjects = currentSubjects;
    }

    public Profile() {
        this.currentSubjects = new ArrayList<>();
        this.aptitudes = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Subject> getCurrentSubjects() {
        return currentSubjects;
    }

    public void setCurrentSubjects(ArrayList<String> selectedSubjectsId) {
        for (String value : selectedSubjectsId) {
            for (int x = 0; x < SubjectCache.getInstance().subjectList.size(); x++) {
                if (value.equals(SubjectCache.getInstance().subjectList.get(x).getId())) {
                    Subject s = new Subject(SubjectCache.getInstance().subjectList.get(x).getId(), SubjectCache.getInstance().subjectList.get(x).getName(), SubjectCache.getInstance().subjectList.get(x).getCredits(), SubjectCache.getInstance().subjectList.get(x).getSkill());
                    currentSubjects.add(s);
                }
            }
        }
    }

    public ArrayList<String> getAptitudes() {
        return this.aptitudes;
    }
}
