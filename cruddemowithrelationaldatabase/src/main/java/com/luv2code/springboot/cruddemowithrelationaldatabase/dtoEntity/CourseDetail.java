package com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Review;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Student;
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
    private Course course;
    private List<Review> reviews;
    private List<Student> students;
}
