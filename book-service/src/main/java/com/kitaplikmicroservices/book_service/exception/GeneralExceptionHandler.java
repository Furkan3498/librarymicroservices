package com.kitaplikmicroservices.book_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

//Spring catches the error in IOC before it goes to the controller layer and returns the trace
    //no extra cost
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handle(BookNotFoundException exception){
        return  new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
