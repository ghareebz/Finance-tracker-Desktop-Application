/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;


public class SavingsGoalController {

    // FXML UI elements
    @FXML private TextField goalAmountField;
    @FXML private DatePicker targetDatePicker;
    @FXML private Label progressLabel;
    @FXML private ProgressBar progressBar;
    @FXML private Label monthlyTipLabel;

    // Handler to load transactions
    TransactionFileHandler handler = new TransactionFileHandler();

    // Calculate total saved = total income - total expenses
    double totalSaved = handler.calculateBalance(); 

    @FXML
    private void handleCalculate() {
        try {
            // Read goal amount and target date from user input
            double goal = Double.parseDouble(goalAmountField.getText());
            LocalDate targetDate = targetDatePicker.getValue();
            LocalDate today = LocalDate.now();

            // Validate input: goal must be positive and date in the future
            if (goal <= 0 || targetDate.isBefore(today)) {
                showAlert("Invalid input", "Please enter a positive goal and a future date.");
                return;
            }

            // Calculate remaining amount and months left to reach the goal
            double remaining = goal - totalSaved;
            long monthsLeft = ChronoUnit.MONTHS.between(
                today.withDayOfMonth(1), 
                targetDate.withDayOfMonth(1)
            );
            monthsLeft = Math.max(monthsLeft, 1); // Avoid divide-by-zero

            // Update progress display
            progressLabel.setText(String.format("You’ve saved $%.2f of $%.2f", totalSaved, goal));
            progressBar.setProgress(Math.min(totalSaved / goal, 1.0)); // Cap progress at 100%
            monthlyTipLabel.setText(String.format("Save $%.2f/month to reach your goal.", remaining / monthsLeft));

        } catch (NumberFormatException e) {
            // Handle case where goal is not a valid number
            showAlert("Error", "Please enter a valid number for goal.");
        }
    }

    @FXML
    private void handleBack() {
        try {
            // Return to dashboard screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) goalAmountField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load Dashboard screen.");
        }
    }

    // Reusable alert method
    private void showAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.show();
    }
}

 
 

