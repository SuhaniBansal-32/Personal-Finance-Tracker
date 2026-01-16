package com.finance.tracker.model;

public class Budget {
    private final Category category;
    private double monthlyLimit;
    private final int month;
    private final int year;

    public Budget(Category category, double monthlyLimit,
                  int month, int year) {
        this.category = category;
        this.monthlyLimit = monthlyLimit;
        this.month = month;
        this.year = year;
    }

    // getters
    public Category getCategory() {
        return category;
    }
    public double getMonthlyLimit() {
        return monthlyLimit;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    // setters
    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    @Override
    public String toString() {
        return String.format("%s: ₹%.2f (%d/%d)",category.getDisplayName(),monthlyLimit,month,year);
    }
}
