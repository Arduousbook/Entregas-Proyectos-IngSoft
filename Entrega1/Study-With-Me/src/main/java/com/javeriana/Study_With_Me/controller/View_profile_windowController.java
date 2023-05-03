package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.Profile_model.Subject;
import com.javeriana.Study_With_Me.model.User_model.Profile;
import com.javeriana.Study_With_Me.model.User_model.User_cache;
import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class View_profile_windowController implements Initializable {



    @FXML
    private VBox subjects;

    @FXML
    private VBox aptitudes;



    @FXML
    private Label profileNamee;

    @FXML
    private Button returnButton;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        String name = User_cache.getCurrentUser().getProfile().getName();
        this.profileNamee.setText(name);
        ArrayList<Subject> subjects_ = User_cache.getCurrentUser().getProfile().getCurrentSubjects();
        for (int i = 0; i < subjects_.size(); i++) {

            Label c = new Label(subjects_.get(i).getName());
            subjects.getChildren().add(c);
        }
    }


    @FXML
    void returnn(ActionEvent event) {
        try {
            if (Application.closeWindow(event)) {
                menuStart();
            } else {
                throw  new NotWindowRunningException("Window not found");
            }
        } catch ( IOException e) {
            Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
        }
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
