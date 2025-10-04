/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;
import java.time.LocalDate;
/**
 *
 * @author a7med
 */
// Expense class extends the abstract Transaction class
// Represents an expense record entered by the user
public class Expense extends Transaction {

    // Constructor initializes an Expense object using the parent Transaction constructor
    public Expense(int id, double amount, LocalDate date, String category, String note) {
        super(id, amount, date, category, note);
    }

    // Overrides the abstract getSummary() method to provide a string summary for this expense
    @Override
    public String getSummary() {
        return "Expense: $" + amount + " for " + category;
    }
}

