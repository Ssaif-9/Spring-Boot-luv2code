package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
