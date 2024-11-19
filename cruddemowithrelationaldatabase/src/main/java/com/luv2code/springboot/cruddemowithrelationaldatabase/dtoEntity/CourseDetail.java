package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetail {
    private CourseDto course;
    private InstructorDto instructor;
    private InstructorDetailDto instructorDetail;
    private List<ReviewDto> reviews;
    private List<StudentDto> students;
}
