package com.souid.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Error> handleUserNotFoundException(UserNotFoundException ex) {
        Error error = new Error("User not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}