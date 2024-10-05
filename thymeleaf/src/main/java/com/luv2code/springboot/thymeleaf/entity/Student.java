package com.luv2code.springboot.thymeleaf.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String firstName;

    @NotNull(message = "is Required!")
    @Size(min = 1 ,message = "must more than 1 character")
    private String lastName;

    private String country;
    private String programmingLanguage;
    private String system;
}
