package com.expense.expense_tracker.DTO;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;

public class ExpenseDTO {

    private String expenseName;

    private int amount;

    private Date date;

    private String description;

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public ExpenseDTO() {
    }

    public ExpenseDTO(String expenseName, int amount, Date date, String description) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    
}
