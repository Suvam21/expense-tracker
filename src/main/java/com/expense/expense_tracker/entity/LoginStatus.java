package com.expense.expense_tracker.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private Boolean status;

    private String token;

    public LoginStatus() {
    }


    public LoginStatus(Long id, String username, String token, Boolean status) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.status = status;
    }
    

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public Boolean getStatus() {
        return status;
    }


}
