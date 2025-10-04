Personal Finance Tracker
=========================

A JavaFX desktop application that helps users track their personal finances — including income, expenses, savings goals, and reports. Built with Scene Builder, JavaFX, and file-based CSV storage (no database).

-------------------------
🛠 Project Features:
-------------------------

1. User Authentication:
   - Login and Register screens with CSV-based storage (users.csv)

2. Dashboard:
   - Summary of balance, total income, total expenses
   - Visual feedback (progress bars)

3. Add Transaction:
   - User can add income or expense
   - Inputs: Amount, Date, Category, Note
   - Stored in transactions.csv

4. View Transactions:
   - Table showing all transactions
   - Filter, sort, edit, delete options (optional)

5. Savings Goal Tracker:
   - Set a Financial Goal
   - Track Progress Toward It
   

-------------------------
📂 File Structure:
-------------------------

- `src/javafxapplication1/`
   - `Main.java` - Entry point
   - `User.java` - User model
   - `Transaction.java` (abstract)
   - `Income.java` / `Expense.java` - Transaction subtypes
   - `TransactionFileHandler.java` - Handles CSV reading/writing
   - `DashboardController.java`, `LoginController.java`, etc.

- `resources/javafxapplication1/`
   - `Login.fxml`
   - `Register.fxml`
   - `Dashboard.fxml`
   - `AddTransaction.fxml`
   - `ViewTransactions.fxml`
   - `Report.fxml`

- `users.csv` - Stores registered user data  
- `transactions.csv` - Stores all transaction records  
- `savings.csv` - Stores user savings goal and progress

-------------------------
🧪 Technologies Used:
-------------------------

- Java 8+
- JavaFX
- Scene Builder
- File I/O (CSV)
- OOP Concepts:
   - Encapsulation
   - Polymorphism
   - Exception Handling
   - Multithreading (optional / for loading animation or file reading)

-------------------------
💡 How to Run:
-------------------------

1. Open the project in NetBeans or IntelliJ
2. Run `Main.java`
3. Use the Register screen to create a new account
4. Login and start managing your finances!

-------------------------
✅ Academic Requirements Covered:
-------------------------

- JavaFX GUI with Scene Builder
- File storage using CSV (no database)
- Polymorphism (via Transaction superclass)
- Exception Handling
- Encapsulation (private fields + getters/setters)
- At least 6 Java classes (excluding FXML/controllers)
- Multithreading (optional if used for animations/loading)

-------------------------
👤 Author:
-------------------------

[Ahmed Mohammed]  
[AAST/Advanced Programming Project]  
[27/5/2025]
