package com.expense.expense_tracker.DTO;

public class LoginResponseDTO {
    private String statusCode;

    private String statusMsg;

    private String token;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String statusCode, String statusMsg, String token) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.token = token;
    }

    public LoginResponseDTO(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
