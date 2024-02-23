package com.mycompany.project;

import static com.mycompany.project.PrimarySnowflakeController.surface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import processing.core.PSurface;
import processing.javafx.PSurfaceFX;

public class SecondaryController implements Initializable{

    public static PSurfaceFX surface;
    public static fillCurve1zoom p;
    protected static Stage stage;
    
    
    @FXML
    public StackPane processing;
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
    
    //PSurface surface = new PSurfaceJFX(sketch1);
    
    Canvas canvas = (Canvas) surface.getNative();
    surface.fx.context = canvas.getGraphicsContext2D();
    processing.getChildren().add(canvas);
    canvas.widthProperty().bind(processing.widthProperty());
    canvas.heightProperty().bind(processing.heightProperty());
}
}