package com.javeriana.Study_With_Me.model.Aptitude_Test;

import java.util.ArrayList;

public class AptitudeInformation {


    // ------ Attributes------
    private String aptitudeName;
    private ArrayList<Integer> numericalScores;
    private double averageAptitudeScore;
    private String qualitativeClassification;


    // ------ Constructors ------

    public AptitudeInformation(String aptitudeName) {
        this.aptitudeName = aptitudeName;
    }

    // ------ Methods -----------


    public String getAptitudeName() {
        return aptitudeName;
    }

    public void setAptitudeName(String aptitudeName) {
        this.aptitudeName = aptitudeName;
    }

    public double getAverageAptitudeScore() {
        return averageAptitudeScore;
    }

    public void setAverageAptitudeScore(double averageAptitudeScore) {
        this.averageAptitudeScore = averageAptitudeScore;
    }

    public String getQualitativeClassification() {
        return qualitativeClassification;
    }

    public void setQualitativeClassification(String qualitativeClassification) {
        this.qualitativeClassification = qualitativeClassification;
    }
}
