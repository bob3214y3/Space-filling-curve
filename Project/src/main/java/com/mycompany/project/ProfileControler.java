package com.mycompany.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ProfileControler implements Initializable {

    @FXML
    private Button ProjectButton;

    @FXML
    private TextArea info;

    @FXML
    private Button documentationButton;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //PSurface surface = new PSurfaceJFX(sketch1);
        info.setEditable(false);
        info.setWrapText(true);
        info.isWrapText();
        ProjectButton.setOnAction(event -> {
            try {
                changeProjects();
            } catch (IOException ex) {
            }
        });

        documentationButton.setOnAction(event -> {
            try {
                changeDocumentation();
            } catch (IOException ex) {
            }
        });

    }

    @FXML
    private void changeProjects() throws IOException {
        App.setRoot("Project");
    }

    @FXML
    private void changeDocumentation() throws IOException {
        App.setRoot("documentation");
    }

}
