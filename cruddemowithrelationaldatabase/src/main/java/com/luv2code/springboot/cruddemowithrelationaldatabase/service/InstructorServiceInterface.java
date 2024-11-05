package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorServiceInterface {

    void saveInstructor(Instructor instructor);

    void saveInstructorWithCourses(Instructor instructor);

    Instructor findInstructorById(int id);

    List<Instructor> findAllInstructors();

    void updateInstructor(Instructor instructor);

    void deleteInstructorById(int id);
}
