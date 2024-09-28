package com.expense.expense_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThymeleafController {
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // register.html
    }
}
