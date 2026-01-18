package com.finance.tracker.ui;
import com.finance.tracker.service.AuthService;
import com.finance.tracker.repository.UserRepository;

import java.awt.*;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner sc;
    private UserRepository userRepository; // database of existing users
    private AuthService authService; // backend for registering, logging and logout users
    private MenuHandler menuHandler; // frontend for collecting data from user

    public ConsoleUI() {
        this.sc = new Scanner(System.in);
        this.userRepository = new UserRepository();
        this.authService = new AuthService(userRepository);
        this.menuHandler = new MenuHandler(sc,authService);
    }

    public void start() {
        boolean running = true;

        while(running) {
            if(!authService.isLoggedIn()) {
                displayMainMenu(); // (Main Menu for user to register, login or logout)
                int choice = getIntInput();
                switch(choice) {
                    case 1:
                        menuHandler.handleRegister();
                        break;
                    case 2:
                        menuHandler.handleLogin();
                        break;
                    case 3:
                        System.out.println("\nThank you for using our Finance Tracker!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            else {
                // After Login this menu will be visible for the tasks that the user can perform with the application
                menuHandler.showDashboardMenu();
                int choice = getIntInput();
                switch(choice) {
                    case 1:
                        System.out.println("\n[Add Transaction - Coming soon...]");
                        break;
                    case 2:
                        System.out.println("\n[View Transactions - Coming soon...]");
                        break;
                    case 3:
                        System.out.println("\n[Delete Transaction - Coming soon...]");
                        break;
                    case 4:
                        System.out.println("\n[Set Budget - Coming soon...]");
                        break;
                    case 5:
                        System.out.println("\n[Budget Status - Coming soon...]");
                        break;
                    case 6:
                        System.out.println("\n[Monthly Report - Coming soon...]");
                        break;
                    case 7:
                        System.out.println("\n[Category Report - Coming soon...]");
                        break;
                    case 8:
                        authService.logOut();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

            if(running) {
                pressEnterToContinue();
            }
        }
        sc.close();
    }

    private void displayMainMenu() {
        System.out.println("\n=================================");
        System.out.println("         MAIN MENU");
        System.out.println("=================================");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("=================================");
    }

    private int getIntInput() {
        System.out.println("Enter your choice: ");
        while(!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
        }
        int input = sc.nextInt();
        sc.nextLine(); // consumes newline
        return input;
    }

    private void pressEnterToContinue() {
        System.out.println("\nPress enter to continue...");
        sc.nextLine();
        clearScreen();
    }

    private void clearScreen() {
        // Print empty lines to simulate clear
        for(int i = 0; i<2; i++) {
            System.out.println();
        }
    }

}
