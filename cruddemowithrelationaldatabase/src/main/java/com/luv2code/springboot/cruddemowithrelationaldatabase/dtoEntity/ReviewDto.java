package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDto {
    private Integer id;
    private String comment;
}
