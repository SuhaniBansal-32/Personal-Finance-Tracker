package com.finance.tracker.ui;
import java.util.Scanner;
import com.finance.tracker.service.AuthService;

public class MenuHandler {
    Scanner scanner;
    AuthService authService;;

    public MenuHandler(Scanner scanner,AuthService authService) {
        this.scanner = scanner;
        this.authService = authService;
    }

    // making various handlers for user-interface to handle various services
    public void handleRegister(){
        System.out.println("\n=== USER REGISTRATION BLOCK ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password:: ");
        String password = scanner.nextLine().trim();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine().trim();

        if(!confirmPassword.equals(password)){
            System.out.println("Passwords do not match");
            return;
        }
        authService.register(username, password);
    }

    public boolean handleLogin(){
        System.out.println("\n=== USER LOGIN BLOCK===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        return authService.login(username,password);
    }

    public void showDashboardMenu() {
        System.out.println("\n=================================");
        System.out.println("         DASHBOARD for USER: " + authService.getCurrentUser().getUsername());
        System.out.println("\n=================================");
        System.out.println("1. Add Transaction");
        System.out.println("2. View All Transactions");
        System.out.println("3. Delete Transaction");
        System.out.println("4. Set Budget");
        System.out.println("5. View Budget Status");
        System.out.println("6. Monthly Report");
        System.out.println("7. Category Report");
        System.out.println("8. Logout");

    }
}
