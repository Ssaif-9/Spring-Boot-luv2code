package com.luv2code.springboot.demosecurity.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebUser {

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String username;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String password;
}
