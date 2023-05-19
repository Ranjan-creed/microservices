package com.example.documentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public Map<String,String> handleBadRequest(){
        Map<String,String> response = new HashMap<>();
        response.put("status","Your input is invalid");

        return response;
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handleEmptyRequestException(){
        Map<String,String> response = new HashMap<>();
        response.put("status","Internal Code Broke");
        return response;
    }
}
