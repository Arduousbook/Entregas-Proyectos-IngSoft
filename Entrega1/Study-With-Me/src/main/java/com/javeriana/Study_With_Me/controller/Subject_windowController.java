package com.javeriana.Study_With_Me.controller;

import com.javeriana.Study_With_Me.model.Profile_model.SubjectCache;
import com.javeriana.Study_With_Me.model.User_model.Profile;
import com.javeriana.Study_With_Me.model.User_model.User_cache;
import com.javeriana.Study_With_Me.model.User_model.User_file_writer;
import com.javeriana.Study_With_Me.model.exceptions.NotWindowRunningException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Subject_windowController implements Initializable{
    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    @FXML
    private VBox Main;

    @FXML
    private Button back;

    @FXML
    private VBox checkBoxArea;

    @FXML
    private Button confirm;

    @FXML
    private Label warning;

    @FXML
    void confirmSubjects(ActionEvent event) {
        ArrayList<String> selectedSubjectsId = new ArrayList<>();
        int cont =0 ;
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                cont += 1;
                selectedSubjectsId.add(checkBox.getId());
            }
        }
        if(cont==0){
            warning.setText("Debe seleccionar por lo menos 1 materia");
        }
        if(cont>9){
            warning.setText("No puede seleccionar mas de 9 materias");
            selectedSubjectsId.clear();
        }
        if(cont>0&&cont<10){

            User_cache.getCurrentUser().getProfile().setCurrentSubjects(selectedSubjectsId);
            User_file_writer.write_user_to_file();
            warning.setText("Se han agregado las materias");
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] subjects = SubjectCache.getInstance().getSubjectStringList();

        for (int i = 0; i < subjects.length; i++) {

            CheckBox c = new CheckBox(subjects[i]);
            c.setId(Integer.toString(i));
            checkBoxArea.getChildren().add(c);
            checkBoxes.add(c);
        }
    }

    @FXML
    protected void onBackClick(ActionEvent actionEvent) {
        try {
            if (Application.closeWindow(actionEvent)) {
                toConfigureProfile();
            } else {
                throw  new NotWindowRunningException("Window not found");
            }
        } catch ( IOException e) {
            Application.show_alert("Window not found", e.getMessage(), Alert.AlertType.ERROR);
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

    public void testStart() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/javeriana/Study_With_Me/view/AptitudeTest_window.fxml"));
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