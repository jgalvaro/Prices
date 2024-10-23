package com.prices.infrastructure.in.exception.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDetails {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(HttpStatus status, String message, String details) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}