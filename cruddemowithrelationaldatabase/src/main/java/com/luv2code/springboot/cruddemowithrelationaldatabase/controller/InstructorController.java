package com.luv2code.springboot.cruddemowithrelationaldatabase.controller;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.CustomException;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.InstructorServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorServiceInterface instructorServiceInterface;

    @PostMapping()
    public void saveInstructor(@RequestBody Instructor instructor) {
        instructorServiceInterface.saveInstructor(instructor);
    }

    @GetMapping("/{instructorId}")
    public Instructor getInstructor(@PathVariable int instructorId) {
        return instructorServiceInterface.findInstructorById(instructorId);
    }

    @GetMapping()
    public List<Instructor> getAllInstructors() {
       return instructorServiceInterface.findAllInstructors();
    }

    @PutMapping()
    public void updateInstructor(@RequestBody Instructor instructor) {
        instructorServiceInterface.updateInstructor(instructor);
    }

    @DeleteMapping("/{instructorId}")
    public void deleteInstructor(@PathVariable int instructorId) {
        instructorServiceInterface.deleteInstructorById(instructorId);
    }

    @ExceptionHandler(value = CustomException.class)
    public String handleCustomException(CustomException e) {
        return e.getMessage();
    }

}
