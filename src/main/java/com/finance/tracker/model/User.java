package com.finance.tracker.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private final String username;
    private final String password;
    private List<Transaction> transactions;
    private Map<String,Budget> budgets;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.transactions = new ArrayList<>();
        this.budgets = new HashMap<>();
    }

    // Getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public Map<String, Budget> getBudgets() {
        return budgets;
    }

    // Helper methods
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void removeTransaction(String transactionId){
        transactions.removeIf(t -> t.getId().equals(transactionId));
    }

    public void addBudget(Budget budget){
        String key = getBudgetKey(budget.getCategory(),budget.getMonth(),budget.getYear());
        budgets.put(key,budget);
    }

    private String getBudgetKey(Category category, int month, int year){
        return category.name() + "_" + month + "_" + year;
    }

    @Override
    public String toString(){
        return "User: " + username + " | Transactions: " + transactions.size()
                + " | Budgets: " + budgets.size();
    }
}

