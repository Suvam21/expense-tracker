package com.expense.expense_tracker.DTO;

public class ExpenseResponseDTO {

    private String statusCode;

    private String statusMsg;

    private ExpenseDTO expense;

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

    public ExpenseDTO getExpense() {
        return expense;
    }

    public void setExpense(ExpenseDTO expense) {
        this.expense = expense;
    }

    public ExpenseResponseDTO(String statusCode, String statusMsg, ExpenseDTO expense) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.expense = expense;
    }

    public ExpenseResponseDTO(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public ExpenseResponseDTO() {
    }

    

}
