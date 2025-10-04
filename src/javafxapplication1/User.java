/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication1;

/**
 *
 * @author a7med
 */
public class User {
    private int id;           // Unique user identifier
    private String username;  // Username for login
    private String email;     // User's email address
    private String password;  // User's password

    // Constructor to initialize all fields
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter for user ID
    public int getId() {
        return id;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }
    
    // Getter for email
    public String getEmail(){
        return email;
    }
    
    // Getter for password
    public String getPassword(){
        return password;
    }

    // Setter for username 
    public void setUsername(String username) {
        this.username = username;
    }
    
    // Setter for password 
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Setter for email
    public void setEmail(String email) {
        this.email = email; 
    }
}

    
    

