package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOEXception(IOException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("can input the file " + ex.getMessage());
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleRequestbodyException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("the requestbody is absent " + ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Object> handleException(HttpMessageNotWritableException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error occurred while writing JSON response");
    }


}
