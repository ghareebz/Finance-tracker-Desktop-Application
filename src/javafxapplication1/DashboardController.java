/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Label balanceLabel;

    @FXML
    private Label incomeLabel;

    @FXML
    private Label expenseLabel;

    @FXML
    private PieChart summaryChart;

    public void initialize() {
        // Called automatically when Dashboard.fxml is loaded

        // Load total income and expense from transactions.csv
        TransactionFileHandler handler = new TransactionFileHandler();
        double totalIncome = handler.getTotalIncome();
        double totalExpense = handler.getTotalExpenses();
        double balance = totalIncome - totalExpense;

        // Display totals in corresponding labels
        incomeLabel.setText("$" + totalIncome);
        expenseLabel.setText("$" + totalExpense);
        balanceLabel.setText("$" + balance);

        // Visual summary with a pie chart
        summaryChart.getData().add(new PieChart.Data("Income", totalIncome));
        summaryChart.getData().add(new PieChart.Data("Expenses", totalExpense));
    }

    @FXML
    private void goToAddTransaction(ActionEvent event) throws IOException {
        // Navigates to AddTransaction.fxml screen
        Parent root = FXMLLoader.load(getClass().getResource("AddTransaction.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goToViewTransactions(ActionEvent event) throws IOException {
        // Navigates to ViewTransactions.fxml screen
        Parent root = FXMLLoader.load(getClass().getResource("ViewTransactions.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goToReports(ActionEvent event) throws IOException {
        // Navigates to the savings goal screen (SavingsGoal.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("SavingsGoal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

