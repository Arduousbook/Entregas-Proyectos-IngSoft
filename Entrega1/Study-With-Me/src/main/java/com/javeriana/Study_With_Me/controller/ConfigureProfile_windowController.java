package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.User_model.Profile;
import com.javeriana.Study_With_Me.model.User_model.User_cache;
import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfigureProfile_windowController implements Initializable {



    @FXML
    private Button continueButton;

    @FXML
    private TextField fillName;

    @FXML
    private Button returnButton;

    @FXML
    private Label warning;


    @FXML
    void onClickContinue(ActionEvent actionEvent) {
        String filledName = this.fillName.getText();
        if (filledName.length()<1){
            this.warning.setText("Error: debe digitar un nombre.");
        }
        else{
            User_cache.getCurrentUser().getProfile().setName(filledName);
            try {

                if (Application.closeWindow(actionEvent)) {

                    subejctStart();
                } else {
                    throw  new NotWindowRunningException("Window not found");
                }
            } catch ( IOException e) {
                Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    public void subejctStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Subject_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void profileName(ActionEvent event) {

    }

    //Los siguientes dos methods regresan a la pantalla de ver perfil
    @FXML
    protected void onClickBack(ActionEvent actionEvent) {
        returnButton.setVisible(false);
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
    public void signupStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/Signup_window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Study With Me");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
