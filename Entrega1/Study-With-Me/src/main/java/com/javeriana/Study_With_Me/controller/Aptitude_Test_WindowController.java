package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.Aptitude_Test.AptitudeScoreCalculator;
import com.javeriana.Study_With_Me.model.Aptitude_Test.Aptitude_Test_QuestionReader;
import com.javeriana.Study_With_Me.model.User_model.User_login;
import com.javeriana.Study_With_Me.model.User_model.User_signup;
import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class Aptitude_Test_WindowController implements Initializable {

    // ---- Attributes -------

    Aptitude_Test_QuestionReader questionReader = new Aptitude_Test_QuestionReader("src/main/java/com/javeriana/Study_With_Me/model/data/Aptitude_Test_Questions.txt");
    ArrayList<String> questions = (ArrayList<String>) questionReader.getQuestions().clone();

    AptitudeScoreCalculator aptitudeScoreCalculator = new AptitudeScoreCalculator();

    private int currentQuestionIndex = 0;

    @FXML
    private Label questionLabel;

    @FXML
    private ChoiceBox<String> choiceBox;


    // ---- Constructor ------


    // ---- Methods -----------
    @Override
    public void initialize (URL arg0, ResourceBundle arg1){
        questionLabel.setText(questions.get(0));

    }


    @FXML
    private void handleNextButton(ActionEvent event) {
        // If "siguiente" button is pressed, the choiceBox value is read.
        String selectedAnswer = choiceBox.getValue();

        // If no option was selected, an alert is shown.
        if (selectedAnswer.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha seleccionado una respuesta");
            alert.setContentText("Por favor, seleccione una respuesta antes de continuar");
            alert.showAndWait();
            return;
        }

        // If a selection was made, the answer is converted and stored as a numerical value using the convertString_to_NumericalScore function.
        convertString_to_NumericalScore(selectedAnswer);

        // After the processing is done, the next question is shown.
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()){
            questionLabel.setText(questions.get(currentQuestionIndex));
            choiceBox.setValue(null);
        } else{ //End of test. When no more questions are available,the next window is shown.
            try {
                if (Application.closeWindow(event)) {
                    viewProfileStart();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // Function that converts the possible String answers from the test to numerical scores.
    // Answers are stored in an array list inside the AptitudeScoreCalculator class.
    public void convertString_to_NumericalScore(String selectedAnswer){

        int numericalScore = 0;

        switch (selectedAnswer) {
            case "Totalmente en Desacuerdo" -> {
                numericalScore = 1;
                aptitudeScoreCalculator.addScore(numericalScore);
            }
            case "En desacuerdo" -> {
                numericalScore = 2;
                aptitudeScoreCalculator.addScore(numericalScore);
            }
            case "Neutral" -> {
                numericalScore = 3;
                aptitudeScoreCalculator.addScore(numericalScore);
            }
            case "De acuerdo" -> {
                numericalScore = 4;
                aptitudeScoreCalculator.addScore(numericalScore);
            }
            case "Totalmente de acuerdo" -> {
                numericalScore = 5;
                aptitudeScoreCalculator.addScore(numericalScore);
            }
        }

    }

    public void viewProfileStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/ViewProfile_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }


}