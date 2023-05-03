package com.javeriana.Study_With_Me.model.Profile_model;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SubjectCache{ //Singleton
    private static SubjectCache instance = null;
    public ArrayList<Subject> subjectList;

    private SubjectCache(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public static SubjectCache getInstance(){
        if(null== instance){
            instance = new SubjectCache(loadSubjects());
        }
        return instance;
    }

    private static ArrayList<Subject> loadSubjects() {
        ArrayList<Subject> returnList = new ArrayList<>();
        try {
            File myObj = new File("src/main/java/com/javeriana/Study_With_Me/model/data/Subjects.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            while (data.equals("END") == false) {
                String obj2[];
                obj2 = data.split(";");
                Subject s = new Subject(obj2[0], obj2[1], obj2[2] ,obj2[3]);
                returnList.add(s);
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return returnList;
    }

    public String[] getSubjectStringList() {
        String [] stringList = new String[SubjectCache.getInstance().subjectList.size()];
        for(int i=0; i< SubjectCache.getInstance().subjectList.size(); i++){
            stringList[i] = SubjectCache.getInstance().subjectList.get(i).getName();
        }
        return stringList;
    }

}