package com.javeriana.Study_With_Me.model.Aptitude_Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
Class that questions of the aptitude test from a .txt file. The format of the .txt file
is as follows:

- All questions were based around Likert scales, which means that all questions had 5
  possible answers, ranging from "Strongly Disagree" to "Strongly Agree".
  - Each category (Strongly Disagree, Disagree, Neutral, Agree, Strongly Agree) was
    assigned a number from 1 to 5, respectively.
    - In spanish, the categories are "Totalmente en desacuerdo", "En desacuerdo",
      "Neutral", "De acuerdo", and "Totalmente de acuerdo".
  - This also means that the file only contains questions, and not answers, as the
    answers are always the same.

- Each line of the file only contains a question.
- Questions are classified into 5 categories, or aptitudes:
    1. Mathematics (Matemáticas).
    2. Programming (programación).
    3. Humanities (Humanidades).
    4. Applied engineering (Ing. Aplicada).
    5. Business (Negocio/Empresarial).
    - Each category has 3 questions.
 */


public class Aptitude_Test_QuestionReader {

    // ----- Attributes: ------

    // Questions are stored in an array list:
    private ArrayList<String> questions;
    String fileName;

    // ---- Constructors:-----
    public Aptitude_Test_QuestionReader(String inputFileName){
        this.fileName = inputFileName;
        this.questions = new ArrayList<String>();
        readQuestions(this.fileName);
    }

    // ----- Methods: -----

    // Reads the questions from the file and stores them in the array list:
    public void readQuestions(String questionsFileName){
        try {
            File file = new File(questionsFileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.questions.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Returns the questions:
    public ArrayList<String> getQuestions(){
        return this.questions;
    }


}
