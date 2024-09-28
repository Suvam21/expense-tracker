package com.expense.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expense_tracker.entity.LoginStatus;

public interface LoginStatusRepository extends JpaRepository<LoginStatus, Long> {

    public LoginStatus findByUsername(String username);

    public LoginStatus findByToken(String token);

}
