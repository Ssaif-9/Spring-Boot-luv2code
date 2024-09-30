package com.luv2code.springboot.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GeneralException {

    @ExceptionHandler(value = CustomException.class)
    public ErrorException customException(CustomException customException) {
        return new ErrorException(customException.getExceptionCode(),customException.getExceptionMessage(), customException.getExceptionDetails(), customException.getExceptionHttpStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> defaultException(Exception exception) {
        return  new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
