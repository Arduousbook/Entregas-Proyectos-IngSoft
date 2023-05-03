package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.User_model.User_cache;
import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Start_windowController implements Initializable {

    // Attributes:


    @FXML
    private Button enter;

    // Constructors:

    public Start_windowController() {
    }

    // Getters and setters:


    // Methods:

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
    @FXML
    protected void onEnterButtonClick(ActionEvent actionEvent) {
        try {
            if (Application.closeWindow(actionEvent)) {
                User_cache.load_user_cache();
                mainStart();
            } else {
                throw  new NotWindowRunningException("Window not found");
            }
        } catch ( IOException e) {
            Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    public void mainStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/main_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }
}