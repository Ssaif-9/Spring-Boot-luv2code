package com.luv2code.springboot.cruddemowithrelationaldatabase.controller;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.InstructorDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.CustomException;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.ExceptionEntity;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.InstructorDetailServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructordetail")
@RequiredArgsConstructor
public class InstructorDetailController {

    private final InstructorDetailServiceInterface instructorDetailServiceInterface;

    @PostMapping
    public void getInstructorDetail(@RequestBody InstructorDetail instructorDetail) {
        instructorDetailServiceInterface.saveInstructorDetail(instructorDetail);
    }

    @GetMapping("/{instructorDetailId}")
    public InstructorDetail getInstructorDetail(@PathVariable int instructorDetailId) {
        return instructorDetailServiceInterface.findInstructorDetailById(instructorDetailId);
    }

    @GetMapping
    public List<InstructorDetail> getAllInstructorDetails() {
        return instructorDetailServiceInterface.findAllInstructorDetails();
    }

    @PutMapping
    public void updateInstructorDetail(@RequestBody InstructorDetail instructorDetail) {
        instructorDetailServiceInterface.updateInstructorDetail(instructorDetail);
    }

    @DeleteMapping("/{instructorDetailId}")
    public void deleteInstructorDetail(@PathVariable int instructorDetailId) {
        instructorDetailServiceInterface.deleteInstructorDetailById(instructorDetailId);
    }

    @ExceptionHandler(value = CustomException.class)
    ResponseEntity<ExceptionEntity> handleCustomException(CustomException e) {
        ExceptionEntity exceptionEntity = new ExceptionEntity(e.getExceptionCode(),e.getExceptionMessage(),e.getExceptionDetails(),e.getExceptionHttpStatus());
        return new ResponseEntity<>(exceptionEntity, HttpStatus.NOT_FOUND);
    }

}
