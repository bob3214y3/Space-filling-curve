


package com.mycompany.project;


import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import processing.core.PApplet;
import processing.javafx.PSurfaceFX;
import static processing.javafx.PSurfaceFX.PApplicationFX.surface;
/**
 * FXML Controller class
 *
 * @author ACER
 */



public class PrimarySnowflakeController implements Initializable {

    public static PSurfaceFX surface;
    public static fillCurve1 p;
    protected static Stage stage;
    
    
    
    @FXML
    private Button Hibert;

    @FXML
    private Button Rook;

    @FXML
    private Button Tetris;

    @FXML
    private Button X;

    @FXML
    private Button Z;

    @FXML
    private Label animationName;

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
    private VBox chosenAnimation;

    @FXML
    private Button primaryButton1;

    @FXML
    private Button primaryButton11;

    @FXML
    private Button primaryButton111;

    @FXML
    private StackPane processing;

    @FXML
    private ImageView projectImg;

    @FXML
    private ImageView projectImg1;

    @FXML
    private ImageView projectImg11;

    @FXML
    private ImageView projectImg111;

    @FXML
    private ImageView projectImg2;

    @FXML
    private ImageView projectImg21;

    @FXML
    private ImageView projectImg211;

    @FXML
    private VBox root;

    @FXML
    private Button snowflake;

    @FXML
    private Button tri;
    
    @FXML
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
                  ex.printStackTrace();
              }
          });
          
          Hibert.setOnAction(event -> {
              try {
                  changeScreen2();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          });
          
          Rook.setOnAction(event -> {
              try {
                  changeScreen3();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          });
          
          X.setOnAction(event -> {
              try {
                  changeScreen4();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          });
          
          Z.setOnAction(event -> {
              try {
                  changeScreen5();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          });
          
          tri.setOnAction(event -> {
              try {
                  changeScreen6();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          });
          Tetris.setOnAction(event -> {
              try {
                  changeScreen7();
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          });     
         
    }   

     @FXML
     private void changeScreen1() throws IOException {
        stage.hide();
        PApplet.main(fillCurve3.class);
    }
     @FXML
     private void changeScreen2() throws IOException {
        stage.hide();
        PApplet.main(HilbertCurve.class);
        
    }  
     
     @FXML
     private void changeScreen3() throws IOException {
        stage.hide();
        PApplet.main(TheRookCurve.class);
    }  
     @FXML
     private void changeScreen4() throws IOException {
        stage.hide();
        PApplet.main(TriangleCurve .class);
    }  
     @FXML
     private void changeScreen5() throws IOException {
        stage.hide();
        PApplet.main(ZCurve.class);
    }  
     @FXML
     private void changeScreen6() throws IOException {
        stage.hide();
        PApplet.main(SierpinskiTri.class);
    }  
     
     @FXML
     private void changeScreen7() throws IOException {
        stage.hide();
        PApplet.main(TerisCurve.class);
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

