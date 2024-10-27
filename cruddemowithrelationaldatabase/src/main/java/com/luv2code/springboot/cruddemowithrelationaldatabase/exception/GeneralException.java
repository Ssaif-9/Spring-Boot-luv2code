package com.luv2code.springboot.cruddemowithrelationaldatabase.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralException {
    @ExceptionHandler(value = CustomException.class)
    ExceptionEntity exceptions(CustomException customException) {
        ExceptionEntity exceptionEntity = new ExceptionEntity(customException.getExceptionCode(),customException.getExceptionMessage(),customException.getExceptionDetails(),customException.getExceptionHttpStatus());
        return exceptionEntity;
    }
}
