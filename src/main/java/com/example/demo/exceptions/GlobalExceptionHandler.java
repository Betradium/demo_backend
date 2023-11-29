package com.example.demo.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import jakarta.servlet.http.HttpServletResponse;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorMessage body;

    @ExceptionHandler(CustomExceptions.MemberExistsException.class)
    public ResponseEntity<?> handleMemberExistsException(CustomExceptions.MemberExistsException e, WebRequest request) {
        body.setTimestamp(LocalDateTime.now());
        body.setHttpStatus(HttpStatus.CONFLICT);
        body.setMessage(e.getMessage());
        body.setPath(request);
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomExceptions.TopicNotFoundException.class)
    public String handleTopicException(Exception ex, HttpServletResponse response) {
        response.setStatus(460);
        return ex.getMessage();
    }

    @ExceptionHandler(CustomExceptions.PostNotFoundException.class)
    public String handlePostException(Exception ex, HttpServletResponse response) {
        response.setStatus(460);
        return ex.getMessage();
    }

    @ExceptionHandler(CustomExceptions.CommentNotFoundException.class)
    public String handleCommentException(Exception ex, HttpServletResponse response) {
        response.setStatus(460);
        return ex.getMessage();
    }

    @ExceptionHandler(CustomExceptions.InvalidTopicException.class)
    public String handleInvalidTopicException(Exception ex, HttpServletResponse response) {
        response.setStatus(405);
        return ex.getMessage();
    }

    @ExceptionHandler(CustomExceptions.InvalidPostException.class)
    public String handleInvalidPostException(Exception ex, HttpServletResponse response) {
        response.setStatus(405);
        return ex.getMessage();
    }

    @ExceptionHandler(CustomExceptions.InvalidCommentException.class)
    public String handleInvalidCommentException(Exception ex, HttpServletResponse response) {
        response.setStatus(405);
        return ex.getMessage();
    }

    @ExceptionHandler(CustomExceptions.InvalidCredentialsException.class)
    public ResponseEntity<?> handleInvalidCredentialsException(CustomExceptions.InvalidCredentialsException e, WebRequest request) {
        body.setTimestamp(LocalDateTime.now());
        body.setHttpStatus(HttpStatus.UNAUTHORIZED);
        body.setMessage(e.getMessage());
        body.setPath(request);
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomExceptions.MemberNotFoundException.class)
    public ResponseEntity<?> handleMemberNotFoundException(CustomExceptions.InvalidCredentialsException e, WebRequest request) {
        body.setTimestamp(LocalDateTime.now());
        body.setHttpStatus(HttpStatus.NOT_FOUND);
        body.setMessage(e.getMessage());
        body.setPath(request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(CustomExceptions.MemberNotAddedException.class)
    public ResponseEntity<?> handleMemberNotAddedException(CustomExceptions.InvalidCredentialsException e, WebRequest request) {
        body.setTimestamp(LocalDateTime.now());
        body.setHttpStatus(HttpStatus.NOT_FOUND);
        body.setMessage(e.getMessage());
        body.setPath(request);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Map<String, Object> mapBody = new LinkedHashMap<>();
        mapBody.put("timestamp", LocalDate.now());
        mapBody.put("status", status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        mapBody.put("errors", errors);
        return new ResponseEntity<>(mapBody, HttpStatus.BAD_REQUEST);
    }
}
