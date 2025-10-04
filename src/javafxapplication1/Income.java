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
// Income class extends the abstract Transaction class
// Represents an income record entered by the user
public class Income extends Transaction {

    // Constructor passes parameters to the Transaction constructor to initialize shared fields
    public Income(int id, double amount, LocalDate date, String category, String note) {
        super(id, amount, date, category, note);
    }

    // Overrides the abstract getSummary() method to provide a summary specific to income
    @Override
    public String getSummary() {
        return "Income: $" + amount + " from " + category;
    } 
}

