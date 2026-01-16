package com.finance.tracker.model;

import java.time.LocalDate;
import java.util.UUID; // universally unique identifier

public class Transaction {
    private final String id;
    private TransactionType type;
    private Category category;
    private double amount;
    private String description;
    private LocalDate date;

    // Constructor
    public Transaction(TransactionType type,
                       Category category,
                       double amount,
                       String description,
                       LocalDate date)
    {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getters
    public String getId(){
        return id;
    }
    public TransactionType getType(){
        return type;
    }
    public Category getCategory(){
        return category;
    }
    public double getAmount(){
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getDate() {
        return date;
    }

    // Setters
    public void setType(TransactionType type){
        this.type = type;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | ₹%.2f | %s | %s",
                date,type,category.getDisplayName(),amount,description,id);
    }

}

