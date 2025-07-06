package com.icodeapp.proyectospring.api.exception.model;

import java.time.LocalDateTime;

public class ErrorResponse {

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private LocalDateTime dateTime;
    private String message;
}
