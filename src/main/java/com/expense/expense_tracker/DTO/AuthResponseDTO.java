package com.expense.expense_tracker.DTO;

public class AuthResponseDTO {
    private String statusCode;

    private String statusMsg;

    //default constructor
    public AuthResponseDTO() {
    }

    //parameterized constructor
    public AuthResponseDTO(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    //getter and setter methods
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

}
