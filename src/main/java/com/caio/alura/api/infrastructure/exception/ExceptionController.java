package com.caio.alura.api.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ValidationException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body("Invalid input detected");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body("Invalid input detected");
    }

    @ExceptionHandler(ValidationException.class) 
    public ResponseEntity<?> handleValidationException(ValidationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
    
}
