package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Student;

import java.util.List;

public interface StudentServiceInterface {

    void addStudent(Student student);

    void addStudentWithCourses(Student student);

    List<Course> getStudentsAndCoursesByStudentId(Integer id);
}
