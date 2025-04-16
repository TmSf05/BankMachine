/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author User
 */
import java.util.HashMap;
import java.util.Map;

enum Role {
    ADMIN, CUSTOMER
}

class User {
    private String username;
    private String password;
    private Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public Role getRole() {
        return role;
    }
}

class BankSystem {
    private Map<String, User> users;

    public BankSystem() {
        users = new HashMap<>();
    }

    public void addUser(String username, String password, Role role) {
        users.put(username, new User(username, password, role));
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.authenticate(password);
    }

    public Role getUserRole(String username) {
        User user = users.get(username);
        return user != null ? user.getRole() : null;
    }
}
