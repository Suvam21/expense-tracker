package com.expense.expense_tracker.service.Iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expense_tracker.entity.Expense;
import com.expense.expense_tracker.repository.ExpenseRepository;
import com.expense.expense_tracker.repository.LoginStatusRepository;
import com.expense.expense_tracker.service.ExpenseService;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private LoginStatusRepository loginStatusRepo;

    @Override
    public String saveExpense(Expense expense, String token) throws Exception{
        if (loginStatusRepo.findByToken(token) != null) {
            expense.setUserName(loginStatusRepo.findByToken(token).getUsername());
            expenseRepo.save(expense);
            return "Expense Added";
        } else {
            throw new Exception("UNAUTHORIZED");
        }
    }

    @Override
    public void deleteExpense(Long id, String token) {
        if (loginStatusRepo.findByToken(token) != null) {
            expenseRepo.deleteById(id);
        } else {
            throw new RuntimeException("UNAUTHORIZED");
        }
    }

    @Override
    public String updateExpense(Long id, Expense expense, String token) throws Exception {
        if (loginStatusRepo.findByToken(token) != null) {
            Expense existingExpense = expenseRepo.findById(id).get();
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setDate(expense.getDate());
            existingExpense.setDescription(expense.getDescription());
            existingExpense.setUserName(loginStatusRepo.findByToken(token).getUsername());
            expenseRepo.save(existingExpense);
            return "Expense Updated";
        } else {
            throw new Exception("UNAUTHORIZED");
        }
    }

    @Override
    public List<Expense> getExpense(String token) throws Exception{
        if (loginStatusRepo.findByToken(token) != null) {
            return expenseRepo.findByUsername(loginStatusRepo.findByToken(token).getUsername());
        } else {
            throw new Exception("UNAUTHORIZED");
        }
    }


}
