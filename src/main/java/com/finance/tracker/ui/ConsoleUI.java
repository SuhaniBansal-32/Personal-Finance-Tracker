package com.finance.tracker.ui;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner sc;

    public ConsoleUI() {
        this.sc = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while(running) {
            displayMainMenu();
            int choice = getIntInput();

            switch(choice) {
                case 1:
                    System.out.println("\n[Register - Coming soon...]");
                    break;
                case 2:
                    System.out.println("\n[Login - Coming soon...]");
                    break;
                case 3:
                    System.out.println("\nThank you for using our Finance Tracker!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
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
