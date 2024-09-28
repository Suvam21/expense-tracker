package com.expense.expense_tracker.mapper;

import com.expense.expense_tracker.DTO.ExpenseDTO;
import com.expense.expense_tracker.entity.Expense;

public class ExpenseToExpenseDTO {

    // Map the expense to expenseDTO
    public static ExpenseDTO mapToExpenseDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setDate(expense.getDate());
        expenseDTO.setDesc(expense.getDescription());
        expenseDTO.setExpenseName(expense.getExpenseName());
        return expenseDTO;
    }
}
