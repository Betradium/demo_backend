package com.example.demo.exceptions;

import java.time.LocalDateTime;
import org.springframework.web.context.request.WebRequest;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private WebRequest path;

    public ErrorResponse(LocalDateTime timestamp, int status, String message, WebRequest path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public WebRequest getPath() {
        return path;
    }
}