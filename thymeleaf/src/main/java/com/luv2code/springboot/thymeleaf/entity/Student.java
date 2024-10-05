package com.luv2code.springboot.thymeleaf.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Range;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;

    @NotNull(message = "is Required!")
    @Size(min = 1 ,message = "must more than 1 character")
    private String lastName;

    @Min(value = 12 ,message = "must greater than 12")
    @Max(value = 33 , message = "must less than 33")
    private int age;

    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$",message = "Valid input , must in form (dd-mm-yyyy)")
    private String birthDate;

    private String country;
    private String programmingLanguage;
    private String system;
}
