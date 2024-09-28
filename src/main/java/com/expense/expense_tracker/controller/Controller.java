package com.expense.expense_tracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expense_tracker.DTO.ExpenseDTO;
import com.expense.expense_tracker.DTO.ExpenseResponseDTO;
import com.expense.expense_tracker.entity.Expense;
import com.expense.expense_tracker.mapper.ExpenseToExpenseDTO;
import com.expense.expense_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<ExpenseResponseDTO> addExpense(@RequestParam String token, @RequestBody Expense expense) {
        try {
            expenseService.saveExpense(expense, token);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ExpenseResponseDTO("201",
                            "Expense Created",
                            ExpenseToExpenseDTO.mapToExpenseDTO(expense)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ExpenseResponseDTO("401",
                            "Unauthorized"));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@PathVariable Long id, @RequestParam String token,
            @RequestBody Expense expense) {
        try {
            expenseService.updateExpense(id, expense, token);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ExpenseResponseDTO("201",
                            "Expense Created",
                            ExpenseToExpenseDTO.mapToExpenseDTO(expense)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ExpenseResponseDTO("401",
                            "Unauthorized"));
        }
    }

    @GetMapping("/get")
    public List<ExpenseDTO> getExpense(@RequestParam String token) {
        try {
            List<Expense> expense = expenseService.getExpense(token);
            List<ExpenseDTO> expenseDTOs = new ArrayList<>();
            for (Expense e : expense) {
                expenseDTOs.add(ExpenseToExpenseDTO.mapToExpenseDTO(e));
            }
            return expenseDTOs;
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ExpenseResponseDTO> deleteExpense(@RequestParam String token, @PathVariable Long id) {
        try {
            expenseService.deleteExpense(id, token);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ExpenseResponseDTO("200",
                            "Expense Deleted"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ExpenseResponseDTO("401",
                            "Unauthorized"));
        }
    }
}
