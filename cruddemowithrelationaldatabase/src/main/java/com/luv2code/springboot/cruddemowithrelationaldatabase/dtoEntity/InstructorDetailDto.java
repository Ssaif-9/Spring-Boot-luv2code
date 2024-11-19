package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorDetailDto {
    private Integer id;
    private String youtubeChannel;
    private String hobby;

}
