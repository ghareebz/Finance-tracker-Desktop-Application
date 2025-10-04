/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;
import java.util.List;
/**
 *
 * @author a7med
 */
public class ReportGenerator {

    // Calculates total income by filtering all transactions of type Income and summing their amounts
    public double calculateTotalIncome(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t instanceof Income) // Only keep income transactions
                .mapToDouble(Transaction::getAmount) // Extract amount
                .sum(); // Sum all income amounts
    }

    // Calculates total expenses by filtering transactions of type Expense and summing their amounts
    public double calculateTotalExpense(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t instanceof Expense) // Only keep expense transactions
                .mapToDouble(Transaction::getAmount) // Extract amount
                .sum(); // Sum all expense amounts
    }

    // Calculates the remaining balance by subtracting total expenses from total income
    public double calculateBalance(List<Transaction> transactions) {
        return calculateTotalIncome(transactions) - calculateTotalExpense(transactions);
    }
}

