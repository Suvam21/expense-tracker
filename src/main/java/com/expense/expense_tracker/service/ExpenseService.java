package com.expense.expense_tracker.service;

import java.util.List;

import com.expense.expense_tracker.entity.Expense;

public interface ExpenseService {

    public String saveExpense(Expense expense, String token) throws Exception;

    public void deleteExpense(Long id, String token);

    public String updateExpense(Long id, Expense expense, String token) throws Exception;

    public List<Expense> getExpense(String token) throws Exception;
}
