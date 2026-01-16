package com.finance.tracker.model;

public enum Category{
    FOOD("Food & Dining"),
    TRANSPORT("Transportation"),
    ENTERTAINMENT("Entertainment"),
    BILLS("Bills & Utilities"),
    SHOPPING("Shopping"),
    HEALTH("Healthcare"),
    EDUCATION("Education & Learning"),
    SALARY("Salary"),
    SAVINGS("Savings"),
    BUSINESS("Business"),
    INVESTMENT("Investment"),
    OTHER("Other");

    private final String displayName;
    private Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
