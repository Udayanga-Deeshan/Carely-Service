package com.pm.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errors.put(error.getField(),error.getDefaultMessage());

        });
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleEmailAlreadysExistsException(EmailAlreadyExistsException ex){
        log.warn("Email Adrees already Exists {}",ex.getMessage());
        HashMap<String, String> errors = new HashMap<>();
        errors.put("message","Email Address Already Exists");
       return ResponseEntity.badRequest().body(errors);
    }
}
