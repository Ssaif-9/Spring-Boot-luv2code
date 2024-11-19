package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.CourseDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.CustomException;
import com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity.InstructorRepoInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImplement implements InstructorServiceInterface{

    private final InstructorRepoInterface instructorRepo;

    public InstructorServiceImplement(InstructorRepoInterface instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepo.save(instructor);
    }


    @Override
    public Instructor findInstructorById(int id) {
        Optional<Instructor> instructorOptional =instructorRepo.findById(id);
        if(instructorOptional.isPresent())
            return instructorOptional.get();
        else
            throw new CustomException("505","Not Found ","Not Found Instructor with id : "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Instructor> findAllInstructors() {
       return instructorRepo.findAll();
    }


    @Override
    public void updateInstructor(Instructor instructor) {
        Optional<Instructor> instructorOptional =instructorRepo.findById(instructor.getId());
        if(instructorOptional.isPresent()){
            instructorOptional.get().setFirstName(instructor.getFirstName());
            instructorOptional.get().setLastName(instructor.getLastName());
            instructorOptional.get().setEmail(instructor.getEmail());
            instructorOptional.get().setInstructorDetail(instructor.getInstructorDetail());

            instructorRepo.save(instructorOptional.get());
        }
    }

    @Override
    public void deleteInstructorById(int id) {
        instructorRepo.deleteById(id);
    }

}
