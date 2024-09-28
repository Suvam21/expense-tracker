package com.expense.expense_tracker.service;

import com.expense.expense_tracker.DTO.LoginDTO;
import com.expense.expense_tracker.entity.User;

public interface UserService {
    
    public void createUser(User user);

    public String login(LoginDTO loginDTO);

    public void logout(String token);
}