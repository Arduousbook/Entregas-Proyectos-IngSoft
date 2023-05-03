package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main_windowController implements Initializable{


    @FXML
    private Button login;

    @FXML
    private Button signup;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent actionEvent) {
        try {
            if (Application.closeWindow(actionEvent)) {
                loginStart();
            } else {
                throw  new NotWindowRunningException("Window not found!");
            }
        } catch ( IOException e) {
            Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    protected void onSignupButtonClick(ActionEvent actionEvent) {
        try {
            if (Application.closeWindow(actionEvent)) {
                signupStart();
            } else {
                throw  new NotWindowRunningException("Window not found");
            }
        } catch ( IOException e) {
            Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void loginStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Login_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }
    public void signupStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Signup_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }
}