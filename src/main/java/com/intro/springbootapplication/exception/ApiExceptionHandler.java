package com.intro.springbootapplication.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException){
        ApiException exception = new ApiException(
                apiRequestException.getMessage(),apiRequestException, HttpStatus.BAD_REQUEST, ZonedDateTime.now()
        );
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundApiRequestException(NotFoundException notFoundException){
        ApiException exception = new ApiException(
                notFoundException.getMessage(),notFoundException, HttpStatus.NOT_FOUND, ZonedDateTime.now()
        );
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }

}
