package com.expense.expense_tracker.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Reference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String expenseName;

    private int amount;

    private Date date;

    @Column(length = 1000)
    private String description;

    private String username;

    // Default Constructor
    public Expense() {
    }

    // Parameterized Constructor
    public Expense(Long id, String expenseName, int amount, Date date, String description, String username) {
        this.id = id;
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.username = username;
    }
    
    // Getters and Setter
    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //toString
    @Override
    public String toString() {
        return "Expense [expenseName=" + expenseName + ", amount=" + amount + ", date=" + date + ", description=" + description + "]";
    }
}
