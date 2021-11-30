package com.tomtom.bank.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){

        final ApiException exception = new ApiException(
            e.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST,
            ZonedDateTime.now()
        );
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<Object> accountNotFoundException(AccountNotFoundException e){

        final ApiException exception = new ApiException(
            e.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND,
            ZonedDateTime.now()
        );
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
