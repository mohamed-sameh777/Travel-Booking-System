package model.users;

public class User {

    protected int userID;
    protected String name;
    protected String email;
    protected String password;
    protected String role;   // Admin or Customer

    public User(int userID, String name, String email, String password, String role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // === Core Responsibilities ===

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    public void viewProfile() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }

    // === Getters ===

    public int getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }
}