package com.javeriana.Study_With_Me.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Start_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study with me");
        stage.setScene(scene);
        stage.show();
    }
    public static boolean closeWindow(ActionEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        return true;
    }
    @FXML
    public static void show_alert(String title, String message, Alert.AlertType alert_type){
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().setStyle("-fx-font-family: Didot");
        alert.setAlertType(alert_type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
    public static void main(String[] args) {
        launch();
    }
}