package com.luv2code.student.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

}
