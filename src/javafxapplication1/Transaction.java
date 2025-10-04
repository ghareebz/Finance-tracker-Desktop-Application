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
public abstract class Transaction {
    // Fields shared by all transactions
    protected int id;
    protected double amount;
    protected LocalDate date;
    protected String category;
    protected String note;
   

    // Constructor to initialize transaction fields
    public Transaction(int id, double amount, LocalDate date, String category, String note) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.note = note;
       
    }

    // Getters for all fields
    public int getId() {
        return id;
    }
    public double getAmount() {
        return amount; 
    }
    public LocalDate getDate() {
        return date; 
    }
    public String getCategory() {
        return category; 
    }
    public String getNote() {
        return note; 
    }
    

    // Abstract method to provide a summary of the transaction - implemented by subclasses
    public abstract String getSummary();
}
