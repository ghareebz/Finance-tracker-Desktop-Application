/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;
import java.io.*;
import java.util.*;
/**
 *
 * @author a7med
 */
public class UserFileHandler {
    private static final String FILE_NAME = "Users.csv";

    // Load all users from the CSV file
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);      // User ID
                String username = parts[1];                // Username
                String email = parts[2];                   // Email
                String password = parts[3];                // Password (stored as plain text here)
                users.add(new User(id, username, email, password));
            }
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }
        return users;
    }

    // Save a new user by appending to the CSV file
    public void saveUser(User user) {
        boolean fileExists = new File(FILE_NAME).exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            // If file doesn't exist, write header first
            if (!fileExists) {
                writer.write("id,username,email,password\n");
            }
            // Write user data in CSV format
            writer.write(user.getId() + "," + user.getUsername() + "," + user.getEmail() + "," + user.getPassword() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }

    // Validate user login by matching username and password
    public boolean validateUserLogin(String username, String password) {
        for (User user : loadUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Login success
            }
        }
        return false; // Login failed
    }

    // Generate a new unique user ID by incrementing the last user's ID
    public int generateUserId() {
        List<User> users = loadUsers();
        return users.isEmpty() ? 1 : users.get(users.size() - 1).getId() + 1;
    }
}

    

