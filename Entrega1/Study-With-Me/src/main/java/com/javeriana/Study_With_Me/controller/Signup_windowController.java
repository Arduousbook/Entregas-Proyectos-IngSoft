package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.User_model.User_cache;
import com.javeriana.Study_With_Me.model.User_model.User_signup;
import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup_windowController implements Initializable {


    @FXML
    private Button back;

    @FXML
    private Button signup;

    @FXML
    private PasswordField password;

    @FXML
    private TextField email;

    @FXML
    private Label warning;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    void onSignupClick(ActionEvent event) {
        String email = this.email.getText();
        String password = this.password.getText();
        int flag = 0;
        flag= User_signup.signup(email, password);
        if (flag == 0){
            this.warning.setText("Error: ha digitado mal su email.");
        }
        else if (flag == 1){
            this.warning.setText("Error: ha digitado mal la contraseña.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Requerimientos para la contraseña");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña debe cumplir con los siguientes requerimientos:\n"
                    + "- Tener una longitud mínima de 10 caracteres.\n"
                    + "- Tener una longitud máxima de 20 caracteres.\n"
                    + "- Tener mínimo un número.\n"
                    + "- Tener mínimo una letra minúscula.\n"
                    + "- Tener mínimo una letra mayúscula.\n"
                    + "- Tener mínimo un carácter especial.\n"
                    + "- No contener espacios.");
            alert.showAndWait();
        } else if (flag == 2){
            this.warning.setText("Error: el correo ya esta registrado.");
        } else {
            this.warning.setText("Registrado con éxito.");
            try {
                if (Application.closeWindow(event)) {
                    User_cache.getCurrentUser().setEmail(email);
                    User_cache.getCurrentUser().setHash_password(password);
                    toConfigureProfile();
                } else {
                    throw  new NotWindowRunningException("Window not found!");
                }
            } catch ( IOException e) {
                Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    public void toConfigureProfile() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/ConfigureProfile_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/main_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }
}