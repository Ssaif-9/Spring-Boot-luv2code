package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.InstructorDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity.InstructorRepoInterface;
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
        return instructorOptional.orElse(null);
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
