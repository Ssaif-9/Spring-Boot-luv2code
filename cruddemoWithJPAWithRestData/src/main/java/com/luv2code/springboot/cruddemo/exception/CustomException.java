package com.luv2code.springboot.cruddemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private String exceptionCode;
    private String exceptionMessage;
    private String exceptionDetails;
    private HttpStatus ExceptionHttpStatus;
}
