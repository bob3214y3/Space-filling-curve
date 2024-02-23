
package com.mycompany.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import processing.core.PApplet;
import processing.javafx.PSurfaceFX;

/**
 * FXML Controller class
 *
 * @author ACER
 */

public class ProjectController implements Initializable {

    public static PSurfaceFX surface; // a static variable for the Processing surface
    public static fillCurve1 p; // a static variable for the Processing sketch
    protected static Stage stage; // a static variable for the stage of the application

    @FXML
    private Button Hibert; //button to run the HilbertCurve sketch

    @FXML
    private Button Rook;//button to run the RookCurve sketch

    @FXML
    private Button Tetris;//button to run the Tetris sketch

    @FXML
    private Button X;//button to run the XCurve sketch

    @FXML
    private Button Z;//button to run the ZCurve sketch

    //circles to be rotated
    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Circle c4;

    @FXML
    private Circle c5;

    @FXML
    private Circle c6;

    @FXML
    private Circle c7;

    @FXML
    private Button documentationButton; //button to change to the documentation screen

    @FXML
    private Button profileButton; //button to change to the profile screen

    @FXML
    private StackPane processing; // a stack pane for displaying the Processing sketch

    @FXML
    private Button snowflake; //button to run the SnowflakeCurve sketch

    @FXML
    private Button tri; //button to run the TriangleCurve sketch

    /*
    initializes the class and sets the properties of the Processing
    surface and the circles to be rotated. It also sets up event handlers for each button 
    to change the screen to a different Processing sketch or FXML file.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Canvas canvas = (Canvas) surface.getNative();
        surface.fx.context = canvas.getGraphicsContext2D();
        processing.getChildren().add(canvas);
        canvas.widthProperty().bind(processing.widthProperty());
        canvas.heightProperty().bind(processing.heightProperty());
        setRotate(c1, true, 3600, 70);
        setRotate(c2, true, 3600, 70);
        setRotate(c3, true, 3600, 70);
        setRotate(c4, true, 3600, 70);
        setRotate(c5, true, 3600, 70);
        setRotate(c6, true, 3600, 70);
        setRotate(c7, true, 3600, 70);

        snowflake.setOnAction(event -> {
            try {
                changeScreen1();
            } catch (IOException ex) {
            }
        });

        Hibert.setOnAction(event -> {
            try {
                changeScreen2();
            } catch (IOException ex) {
            }
        });

        Rook.setOnAction(event -> {
            try {
                changeScreen3();
            } catch (IOException ex) {
            }
        });

        X.setOnAction(event -> {
            try {
                changeScreen4();
            } catch (IOException ex) {
            }
        });

        Z.setOnAction(event -> {
            try {
                changeScreen5();
            } catch (IOException ex) {
            }
        });

        tri.setOnAction(event -> {
            try {
                changeScreen6();
            } catch (IOException ex) {
            }
        });
        Tetris.setOnAction(event -> {
            try {
                changeScreen7();
            } catch (IOException ex) {
            }
        });

        profileButton.setOnAction(event -> {
            try {
                changeProfile();
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

    /*
    methods to change the screen to the corresponding Processing sketch.
     */
    @FXML
    private void changeScreen1() throws IOException {

//        surface.pauseThread();
        PApplet sketch = new fillCurve3();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);

    }

    @FXML
    private void changeScreen2() throws IOException {
//        surface.pauseThread();
        PApplet sketch = new HilbertCurve();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);

    }

    @FXML
    private void changeScreen3() throws IOException {
        PApplet sketch = new TheRookCurve();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);
    }

    @FXML
    private void changeScreen4() throws IOException {
        PApplet sketch = new TriangleCurve();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);

    }

    @FXML
    private void changeScreen5() throws IOException {
        PApplet sketch = new ZCurve();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);

    }

    @FXML
    private void changeScreen6() throws IOException {
        PApplet sketch = new SierpinskiTri();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);

    }

    @FXML
    private void changeScreen7() throws IOException {
        PApplet sketch = new TerisCurve();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs, sketch);
    }

    /*
     methods to change the screen to the profile or documentation FXML files
     */
    @FXML
    private void changeProfile() throws IOException {
        App.setRoot("Profile");
    }

    @FXML
    private void changeDocumentation() throws IOException {
        App.setRoot("documentation");
    }

    /*
     a method to rotate a circle by a given angle over a given number of cycles.
     */
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
