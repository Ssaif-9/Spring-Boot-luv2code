package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.CourseDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InstructorServiceInterface {

    void saveInstructor(Instructor instructor);

    Instructor findInstructorById(int id);

    List<Instructor> findAllInstructors();

    void updateInstructor(Instructor instructor);

    void deleteInstructorById(int id);


}
