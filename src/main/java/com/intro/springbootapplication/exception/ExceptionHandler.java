package com.intro.springbootapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;

public class ExceptionHandler {

    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException){
        ApiException exception = new ApiException(
                apiRequestException.getMessage(),apiRequestException, HttpStatus.BAD_REQUEST, ZonedDateTime.now()
        );
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }

}
