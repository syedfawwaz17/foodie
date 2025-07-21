package com.foodie.backend.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private Map<String, String> validationErrors;

    public ErrorResponse(String message, int status, LocalDateTime timestamp, Map<String, String> validationErrors) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.validationErrors = validationErrors;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Map<String, String> getValidationErrors() { return validationErrors; }
    public void setValidationErrors(Map<String, String> validationErrors) { this.validationErrors = validationErrors; }
}

