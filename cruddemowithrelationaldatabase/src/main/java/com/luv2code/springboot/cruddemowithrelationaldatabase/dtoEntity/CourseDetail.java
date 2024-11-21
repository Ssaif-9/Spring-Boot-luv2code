package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDetail {
    private CourseDto course;
    private InstructorDto instructor;
    private InstructorDetailDto instructorDetail;
    private List<ReviewDto> reviews;
    private List<StudentDto> students;
}
