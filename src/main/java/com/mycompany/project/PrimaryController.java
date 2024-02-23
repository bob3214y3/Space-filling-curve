


package com.mycompany.project;


//import javax.swing.JFrame;
//import com.mycompany.project.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PrimaryController implements Initializable {


    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Button play;
    @FXML
    private Button primaryButton;
    @FXML
    private Button primaryButton1;
    @FXML
    private Button primaryButton11;
    @FXML
    private Button primaryButton111;
    @FXML
    private ImageView projectImg;
    @FXML
    private Button primaryButton12;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void play(ActionEvent event) {
        setRotate(c1, true, 360, 10);
        setRotate(c2, true, 1000, 10);
        setRotate(c3, true, 1200, 10);
    }

    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        App.setRoot("primarySnowflake");
    } 
    
    private void setRotate(Circle c, boolean reverse, int angle, int duration) {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);
        rt.setAutoReverse(reverse);
        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(18);
        rt.play();

}

    
}

