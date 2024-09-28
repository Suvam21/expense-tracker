package com.expense.expense_tracker.service.Iservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expense_tracker.DTO.LoginDTO;
import com.expense.expense_tracker.DTO.LoginResponseDTO;
import com.expense.expense_tracker.entity.LoginStatus;
import com.expense.expense_tracker.entity.User;
import com.expense.expense_tracker.repository.LoginStatusRepository;
import com.expense.expense_tracker.repository.UserRepository;
import com.expense.expense_tracker.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LoginStatusRepository loginStatusRepository;

    private static final int TOKEN_LENGTH = 20;
    private static final String TOKEN_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public void createUser(User user) {
        userRepo.save(user);

        // Create a new login status for the user
        LoginStatus loginStatus = new LoginStatus();
        loginStatus.setUsername(user.getUsername());
        loginStatus.setStatus(false);
        loginStatusRepository.save(loginStatus);
    }

    @Override
    public String login(LoginDTO loginDTO) {
        if (userRepo.findByUsername(loginDTO.getUsername()).getPassword().equals(loginDTO.getPassword())) {
            // Generate a random token and return it
            String token = generateToken();

            // Update the login status
            LoginStatus loginStatus = loginStatusRepository.findByUsername(loginDTO.getUsername());
            loginStatus.setStatus(true);
            loginStatus.setToken(token);
            loginStatusRepository.save(loginStatus);

            return token;
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }

    @Override
    public void logout(String token) {
        if (loginStatusRepository.findByToken(token) != null) {
            LoginStatus loginStatus = loginStatusRepository.findByToken(token);
            loginStatus.setStatus(false);
            loginStatus.setToken(null);
            loginStatusRepository.save(loginStatus);
        } else {
            throw new RuntimeException("Invalid Token");
        }
    }

    // Generates a random token
    private String generateToken() {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int index = (int) (TOKEN_CHARACTERS.length() * Math.random());
            token.append(TOKEN_CHARACTERS.charAt(index));
        }
        return token.toString();
    }

}
