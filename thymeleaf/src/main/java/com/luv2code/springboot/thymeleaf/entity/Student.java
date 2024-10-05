package com.luv2code.springboot.thymeleaf.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    private String country;
    private String programmingLanguage;
    private String system;
}
