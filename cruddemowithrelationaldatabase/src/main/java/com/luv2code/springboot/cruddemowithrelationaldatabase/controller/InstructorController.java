package com.luv2code.springboot.cruddemowithrelationaldatabase.controller;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.InstructorDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.InstructorDetailServiceInterface;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.InstructorServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {


    private final InstructorServiceInterface instructorService;
    private final InstructorDetailServiceInterface instructorDetailService;



    @PostMapping("/instructor")
    public void saveInstructor(@RequestBody Instructor instructor) {
        instructorService.saveInstructor(instructor);
    }

    @PostMapping("/instructordetail")
    public void getInstructorDetail(@RequestBody InstructorDetail instructorDetail) {
        instructorDetailService.saveInstructorDetail(instructorDetail);
    }

    @GetMapping("/instructor/{instructorid}")
    public Instructor getInstructor(@PathVariable int instructorid) {
        return instructorService.findInstructorById(instructorid);
    }

    @GetMapping("/instructordetail/{instructordetail}")
    public InstructorDetail getInstructorDetail(@PathVariable int instructordetail) {
        return instructorDetailService.findInstructorDetailById(instructordetail);
    }

    @GetMapping("/instructor")
    public List<Instructor> getAllInstructors() {
       return instructorService.findAllInstructors();
    }

    @GetMapping("/instructordetail")
    public List<InstructorDetail> getAllInstructorDetails() {
        return instructorDetailService.findAllInstructorDetails();
    }

    @PutMapping("/instructor")
    public void updateInstructor(@RequestBody Instructor instructor) {
        instructorService.updateInstructor(instructor);
    }

    @PutMapping("/instructordetail")
    public void updateInstructorDetail(@RequestBody InstructorDetail instructorDetail) {
        instructorDetailService.updateInstructorDetail(instructorDetail);
    }

    @DeleteMapping("/instructor/{instructorid}")
    public void deleteInstructor(@PathVariable int instructorid) {
        instructorService.deleteInstructorById(instructorid);
    }

    @DeleteMapping("/instructordetail/{instructordetail}")
    public void deleteInstructorDetail(@PathVariable int instructordetail) {
        instructorDetailService.deleteInstructorDetailById(instructordetail);
    }


}
