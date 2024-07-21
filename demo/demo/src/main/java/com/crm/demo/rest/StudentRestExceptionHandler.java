package com.crm.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    //add exceptin handler code here

    //add exception handler useing @ExceptionHandler annotation
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(studentNoteFoundException exc){
        //create a studentErrorResponse
        studentErrorResponse error=new studentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());

        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add nother exception handler
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(Exception exc){

        studentErrorResponse error=new studentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());

        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);    }
}
