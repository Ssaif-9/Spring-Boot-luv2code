package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
