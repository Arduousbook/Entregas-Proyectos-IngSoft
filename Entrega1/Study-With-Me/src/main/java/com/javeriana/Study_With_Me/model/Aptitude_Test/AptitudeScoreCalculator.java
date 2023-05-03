package com.javeriana.Study_With_Me.model.Aptitude_Test;

import java.util.ArrayList;


public class AptitudeScoreCalculator {

    // ------ Attributes------
    private ArrayList<Integer> answers = new ArrayList<Integer>(); // Array that contains all (15) answers from the user.

    AptitudeInformation mathAptitude = new AptitudeInformation("Matemáticas");
    AptitudeInformation programmingAptitude = new AptitudeInformation("Programación");
    AptitudeInformation businessAptitude = new AptitudeInformation("Negocios");
    AptitudeInformation engineeringAptitude = new AptitudeInformation("Ingeniería");
    AptitudeInformation humanitiesAptitude = new AptitudeInformation("Humanidades");


    // ------ Constructors ------


    // ---- Methods -----
    public void addScore(int numericalScore) {
        answers.add(numericalScore);
    }


    // Function that assigns a category (string) to each aptitude, according to its numerical value.
    private String classify_from_numericalAverage (double aptitudeAverage) {

        String qualitativeClassification = "";

        if (aptitudeAverage < 2)
            qualitativeClassification = "Carente";
        if (aptitudeAverage < 3)
            qualitativeClassification = "Promedio";
        if (aptitudeAverage < 4)
            qualitativeClassification = "Bueno";
        if (aptitudeAverage < 5)
            qualitativeClassification = "Excelente";

        return qualitativeClassification;
    }


    // Function that calculates the numerical average of the answers for each aptitude, and also assigns
    // a qualitative classification to each aptitude.
    private void calculateNumericalAverages (ArrayList<Integer> aptitudeAnswers) {

        /* As of now (first sprint), all answers, from all aptitudes are contained inside the same array list.
        - Questions 1 to 3 correspond to the Math aptitude.
        - Questions 4 to 6 correspond to the Programming aptitude.
        - Questions 7 to 9 correspond to the Business aptitude.
        - Questions 10 to 12 correspond to the Engineering aptitude.
        - Questions 13 to 15 correspond to the Humanities aptitude.
         */

        double aptitudeAverage = 0;

        // Average numerical score for the Math aptitude.
        for (int i = 0; i < 2; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        mathAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        mathAptitude.setQualitativeClassification(classify_from_numericalAverage(mathAptitude.getAverageAptitudeScore()));

        // Average numerical score for the Programming aptitude.
        aptitudeAverage = 0;
        for (int i = 3; i < 5; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        programmingAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        programmingAptitude.setQualitativeClassification(classify_from_numericalAverage(programmingAptitude.getAverageAptitudeScore()));

        // Average numerical score for the Business aptitude.
        aptitudeAverage = 0;
        for (int i = 6; i < 8; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        businessAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        businessAptitude.setQualitativeClassification(classify_from_numericalAverage(businessAptitude.getAverageAptitudeScore()));

        // Average numerical score for the Engineering aptitude.
        aptitudeAverage = 0;
        for (int i = 9; i < 11; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        engineeringAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        engineeringAptitude.setQualitativeClassification(classify_from_numericalAverage(engineeringAptitude.getAverageAptitudeScore()));

        // Average numerical score for the Humanities aptitude.
        aptitudeAverage = 0;
        for (int i = 12; i < 14; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        humanitiesAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        humanitiesAptitude.setQualitativeClassification(classify_from_numericalAverage(humanitiesAptitude.getAverageAptitudeScore()));


    }

    private ArrayList<String> StringAptitudes (ArrayList<Integer> aptitudeAnswers) {

        /* As of now (first sprint), all answers, from all aptitudes are contained inside the same array list.
        - Questions 1 to 3 correspond to the Math aptitude.
        - Questions 4 to 6 correspond to the Programming aptitude.
        - Questions 7 to 9 correspond to the Business aptitude.
        - Questions 10 to 12 correspond to the Engineering aptitude.
        - Questions 13 to 15 correspond to the Humanities aptitude.
         */

        ArrayList<String> aptitudes_ = new ArrayList<>();

        double aptitudeAverage = 0;

        // Average numerical score for the Math aptitude.
        for (int i = 0; i < 2; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        mathAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        mathAptitude.setQualitativeClassification(classify_from_numericalAverage(mathAptitude.getAverageAptitudeScore()));
        aptitudes_.add("Matemáticas: "+mathAptitude.getQualitativeClassification());
        // Average numerical score for the Programming aptitude.
        aptitudeAverage = 0;
        for (int i = 3; i < 5; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        programmingAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        programmingAptitude.setQualitativeClassification(classify_from_numericalAverage(programmingAptitude.getAverageAptitudeScore()));
        aptitudes_.add("Programación: "+programmingAptitude.getQualitativeClassification());

        // Average numerical score for the Business aptitude.
        aptitudeAverage = 0;
        for (int i = 6; i < 8; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        businessAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        businessAptitude.setQualitativeClassification(classify_from_numericalAverage(businessAptitude.getAverageAptitudeScore()));
        aptitudes_.add("Negocios: "+businessAptitude.getQualitativeClassification());

        // Average numerical score for the Engineering aptitude.
        aptitudeAverage = 0;
        for (int i = 9; i < 11; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        engineeringAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        engineeringAptitude.setQualitativeClassification(classify_from_numericalAverage(engineeringAptitude.getAverageAptitudeScore()));
        aptitudes_.add("Ingeniería: "+engineeringAptitude.getQualitativeClassification());

        // Average numerical score for the Humanities aptitude.
        aptitudeAverage = 0;
        for (int i = 12; i < 14; i++) {
            aptitudeAverage += aptitudeAnswers.get(i);
        }
        humanitiesAptitude.setAverageAptitudeScore(aptitudeAverage = aptitudeAverage/ 3);
        humanitiesAptitude.setQualitativeClassification(classify_from_numericalAverage(humanitiesAptitude.getAverageAptitudeScore()));
        aptitudes_.add("Humanidades: "+humanitiesAptitude.getQualitativeClassification());

        return aptitudes_;
    }
}
