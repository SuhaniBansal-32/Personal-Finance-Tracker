package com.finance.tracker;

import com.finance.tracker.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("    Personal Finance Tracker v1.0   ");
        System.out.println("=================================");

        ConsoleUI ui = new ConsoleUI();
        ui.start();


    }
}