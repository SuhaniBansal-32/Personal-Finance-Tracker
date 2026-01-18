package com.finance.tracker.service;

import com.finance.tracker.repository.UserRepository;
import com.finance.tracker.model.User;

public class AuthService {
    UserRepository userRepository;
    User currentUser;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.currentUser = null;
    }

    // adding various services for users before using the application

    // 1) Register service

    public boolean register(String username, String password) {
        if(username == null || username.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            return false;
        }

        if(password == null || password.trim().isEmpty() || password.length() < 6) {
            System.out.println("Password cannot be empty. It must have at least 6 characters.");
            return false;
        }

        if(userRepository.userExists(username)) {
            System.out.println("Username already exists");
            return false;
        }

        // Create and Store new User
        User newUser = new User(username, password);
        userRepository.addUser(newUser);
        System.out.println("Registration successful! Please Login...");
        return true;
    }

    // 2) Login Service
    public boolean login(String username, String password){
        // checking if the user exists
        if(!userRepository.userExists(username)) {
            System.out.println("User not found");
            return false;
        }
        User user = userRepository.getUser(username);

        if(!user.getPassword().equals(password)) {
            System.out.println("Incorrect Password");
            return false;
        }

        currentUser = user;
        System.out.println("Login Successful, Welcome, " + username + "!");
        return true;
    }

    // 3) LogOut
    public void logOut() {
        if(currentUser != null) {
            System.out.println("Goodbye, " + currentUser.getUsername() + "!");
            System.out.println("Thanks for using the finance tracker!");
            currentUser = null;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}
