/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddTransactionController {

    @FXML
private RadioButton incomeRadio;

@FXML
private RadioButton expenseRadio;

@FXML
private ToggleGroup typeGroup;

    @FXML
    private TextField amountField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField categoryField;

    @FXML
    private TextArea noteField;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;
@FXML
     private void submitTransaction(ActionEvent event) {
    try {
        // Determine the type of transaction based on selected radio button
        String type;
        if (incomeRadio.isSelected()) {
            type = "Income";
        } else {
            type = "Expense";
        }

        // Parse and collect input values from the form
        double amount = Double.parseDouble(amountField.getText());
        LocalDate date = datePicker.getValue();
        String category = categoryField.getText();
        String note = noteField.getText();

        // Create a file handler to manage transactions
        TransactionFileHandler handler = new TransactionFileHandler();

        // Generate a unique ID for the transaction
        int id = handler.generateTransactionId();

        // Create the appropriate Transaction object based on type
        Transaction t;
        if (type.equals("Income")) {
            t = new Income(id, amount, date, category, note);
        } else {
            t = new Expense(id, amount, date, category, note);
        }

        // Save the transaction to the CSV file
        handler.saveTransaction(t);

        // Show success alert and reset form
        showAlert("Success", "Transaction saved successfully!");
        clearForm();

    } catch (Exception e) {
        // Catch any error (parsing, saving, etc.) and show an alert
        showAlert("Error", "Invalid input: " + e.getMessage());
    }
}

@FXML
private void goBack(ActionEvent event) throws IOException {
    // Load Dashboard screen and switch the scene
    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
}

private void showAlert(String title, String msg) {
    // Utility method to show alerts with a title and message
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(msg);
    alert.showAndWait();
}

private void clearForm() {
    // Resets all form fields to default state after submission
    amountField.clear();
    categoryField.clear();
    noteField.clear();
    datePicker.setValue(LocalDate.now());
    incomeRadio.setSelected(true);     // Default back to income
    expenseRadio.setSelected(false);   // Ensure expense is unselected
}
}
