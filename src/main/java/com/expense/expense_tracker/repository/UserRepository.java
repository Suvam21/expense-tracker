package com.expense.expense_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expense_tracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUsername(String username);
}
