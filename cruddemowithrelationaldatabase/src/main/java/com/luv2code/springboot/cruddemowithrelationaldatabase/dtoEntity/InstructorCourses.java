package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstructorCourses {
    private Instructor instructor;
    private List<CourseDetail> courses;
}
