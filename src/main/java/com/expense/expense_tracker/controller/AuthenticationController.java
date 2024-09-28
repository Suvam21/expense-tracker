package com.expense.expense_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expense_tracker.DTO.AuthResponseDTO;
import com.expense.expense_tracker.DTO.LoginDTO;
import com.expense.expense_tracker.DTO.LoginResponseDTO;
import com.expense.expense_tracker.entity.User;
import com.expense.expense_tracker.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AuthResponseDTO("201", "User Created"));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
            String token = userService.login(loginDTO);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new LoginResponseDTO("200", "Login Successful", token));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponseDTO("401", "Invalid Credentials"));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<LoginResponseDTO> logout(String token) {
        try {
            userService.logout(token);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new LoginResponseDTO("200", "Logout Successful"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponseDTO("401", "Unauthorized"));
        }
        
    }
    
}
