package com.luv2code.springboot.cruddemowithrelationaldatabase.exception;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionEntity {
    private String exceptionCode;
    private String exceptionMessage;
    private String exceptionDetails;
    private HttpStatus exceptionHttpStatus;
}
