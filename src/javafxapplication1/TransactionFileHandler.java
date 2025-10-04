/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TransactionFileHandler {
    private static final String FILE_NAME = "transactions.csv";

    // Save a transaction to the CSV file (appends to file)
    public void saveTransaction(Transaction t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            // Format: id,type,amount,date,category,note
            String line = String.format("%d,%s,%.2f,%s,%s,%s",
                    t.getId(),
                    t instanceof Income ? "Income" : "Expense",
                    t.getAmount(),
                    t.getDate(),
                    t.getCategory(),
                    t.getNote());
            bw.write(line);
            bw.newLine();  // Write a newline after each transaction
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load all transactions from the CSV file
    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split line by commas, -1 to include empty trailing fields if any
                String[] data = line.split(",", -1);
                if (data.length < 6) continue;  // Make sure line has enough data

                int id = Integer.parseInt(data[0]);
                String type = data[1];
                double amount = Double.parseDouble(data[2]);
                LocalDate date = LocalDate.parse(data[3]);
                String category = data[4];
                String note = data[5];

                // Create Income or Expense object based on the type
                Transaction t;
                if (type.equalsIgnoreCase("Income")) {
                    t = new Income(id, amount, date, category, note);
                } else {
                    t = new Expense(id, amount, date, category, note);
                }
                transactions.add(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }


    // Calculate total income from all transactions
public double getTotalIncome() {
    return loadTransactions().stream()
            .filter(t -> t instanceof Income)
            .mapToDouble(Transaction::getAmount)
            .sum();
}

// Calculate total expenses from all transactions
public double getTotalExpenses() {
    return loadTransactions().stream()
            .filter(t -> t instanceof Expense)
            .mapToDouble(Transaction::getAmount)
            .sum();
}

// Generate a new unique transaction ID by finding the max existing ID + 1
public int generateTransactionId() {
    return loadTransactions().stream()
            .mapToInt(Transaction::getId)
            .max()
            .orElse(0) + 1;
}

// Load all transactions from the CSV file (similar to loadTransactions but explicit here)
public List<Transaction> loadAllTransactions() {
    List<Transaction> transactions = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                int id = Integer.parseInt(parts[0]);
                String type = parts[1];
                double amount = Double.parseDouble(parts[2]);
                LocalDate date = LocalDate.parse(parts[3]);
                String category = parts[4];
                String note = parts[5];

                Transaction t;
                if (type.equalsIgnoreCase("Income")) {
                    t = new Income(id, amount, date, category, note);
                } else {
                    t = new Expense(id, amount, date, category, note);
                }

                transactions.add(t);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return transactions;
}

// Calculate the balance (total income - total expenses) from the CSV file directly
public double calculateBalance() {
    double income = 0;
    double expense = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                double amount = Double.parseDouble(parts[2]);
                if (parts[1].equalsIgnoreCase("Income")) {
                    income += amount;
                } else if (parts[1].equalsIgnoreCase("Expense")) {
                    expense += amount;
                }
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }

    return income - expense;
}




}
