package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.User_model.User;
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
import java.net.URL;
import java.util.ResourceBundle;

public class Login_windowController implements Initializable {


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    private Button back;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField email;

    @FXML
    private Label warning;

    @FXML
    protected void onLoginClick(ActionEvent actionEvent) {

        String email = this.email.getText();
        String password = this.password.getText();
        int flag = 0;
        flag= User_login.login(email, password);
        if (flag == 0){
            this.warning.setText("Error: el usuario no se encuentra registrado.");
        }
        else if (flag == 1){
            this.warning.setText("Error: La contraseña es incorrecta.");

        } else {
            this.warning.setText("Login con éxito.");
            try {
                if (Application.closeWindow(actionEvent)) {
                    menuStart();
                } else {
                    throw  new NotWindowRunningException("Window not found");
                }
            } catch ( IOException e) {
                Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
            }
        }

    }

    @FXML
    protected void onBackClick(ActionEvent actionEvent) {
        try {
            if (Application.closeWindow(actionEvent)) {
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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Main_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }

    public void menuStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Menu_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }
}
