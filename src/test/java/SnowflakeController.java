

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import processing.javafx.PSurfaceFX;

public class SnowflakeController implements Initializable {

   
    //public static PSurfaceFX surface;
    //public static fillCurve1 p;
    //protected static Stage stage;
    
    @FXML
    private VBox chosenAnimation;
    @FXML
    private Label animationName;
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
    //@FXML
    //private StackPane processing;
    /**
     * Initializes the controller class.
     */
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
  /*  private void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    } 
    
    /*
    public void initialize(URL url, ResourceBundle rb) {
        //Canvas canvas = (Canvas) surface.getNative();
      
            surface.fx.context = canvas.getGraphicsContext2D();
            processing.getChildren().add(canvas);
            canvas.widthProperty().bind(processing.widthProperty());
            canvas.heightProperty().bind(processing.heightProperty()); 
        
            
    }    
    
   
    private void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("primary"); 
    } */
}
