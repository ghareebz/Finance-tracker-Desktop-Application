/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void registerUser(ActionEvent event) throws IOException {
    // Get and trim user inputs
    String username = usernameField.getText().trim();
    String email = emailField.getText().trim();
    String password = passwordField.getText().trim();

    // Input validation
    if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
        showAlert("Error", "Please fill in all fields.");
        return;
    }

    // Create new user with generated ID and save to file
    UserFileHandler userHandler = new UserFileHandler();
    int newId = userHandler.generateUserId();
    User newUser = new User(newId, username, email, password);
    userHandler.saveUser(newUser);

    // Show success message and navigate to login screen
    showAlert("Success", "User registered successfully!");
    goToLogin(event);
}

@FXML
private void goToLogin(ActionEvent event) throws IOException {
    // Switch to Login.fxml screen
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
}

private void showAlert(String title, String content) {
    // Utility method to show alert dialogs
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
}
