package com.mycompany.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import processing.javafx.PSurfaceFX;

/**
 *
 * App class to run the JavaFX application
 */
public class App extends Application {

// Variables to hold the surface, scene and stage
    public static PSurfaceFX surface;
    public static Scene scene;
    public static Stage stage;

    /**
     *
     * Start method to set up the scene and display the primary stage
     *
     * @param primaryStage The main window of the application
     *
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

// Load the FXML file and set it as the root node of the scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Project.fxml"));
        Parent root = loader.load();

// Set the stage in the ProjectController class
        ProjectController.stage = primaryStage;

//Set stage logo
        Image icon = new Image(getClass().getResourceAsStream("logo.png"));
        primaryStage.getIcons().add(icon);
        
// Create the scene and set its size 
        scene = new Scene(root, 1400, 720);
            
// Set the scene in the primary stage and display it
        primaryStage.setScene(scene);
        primaryStage.show();

// Set the stage in the PSurfaceFX class and the ProjectController class
        surface.stage = primaryStage;
        ProjectController.stage = primaryStage;
    }

    /**
     *
     * Method to change the root node of the scene
     *
     * @param fxml The name of the FXML file to be loaded
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     *
     * Method to load the FXML file and return its root node
     *
     * @param fxml The name of the FXML file to be loaded
     * @return The root node of the FXML file
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
