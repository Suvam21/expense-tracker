package com.expense.expense_tracker.DTO;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private String apiPath;

    private String errorCode;

    private String errorMsg;

    private LocalDateTime errorTime;

    public ErrorResponseDTO() {
    }

    public ErrorResponseDTO(String apiPath, String errorCode, String errorMsg, LocalDateTime errorTime) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.errorTime = errorTime;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(LocalDateTime errorTime) {
        this.errorTime = errorTime;
    }

    
    

}
