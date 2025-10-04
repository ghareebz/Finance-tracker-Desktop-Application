/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author a7med
 */
// Main class that starts the JavaFX application
public class JavaFXApplication1 extends Application {

    // The entry point for JavaFX applications
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the Login.fxml file as the starting screen
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

            // Create a new scene with the loaded FXML layout
            Scene scene = new Scene(root);

            // Set window title and scene, then display the window
            primaryStage.setTitle("Personal Finance Tracker");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            // Print any exceptions to the console for debugging
            e.printStackTrace();
        }
    }

    // The standard Java main method
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}

