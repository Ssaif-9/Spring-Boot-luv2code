package com.luv2code.springboot.cruddemowithrelationaldatabase.controller;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Student;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.StudentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServiceInterface studentServiceInterface;

    @PostMapping()
    public void addStudent(@RequestBody Student student) {
        studentServiceInterface.addStudent(student);
    }

    @PostMapping("/courses")
    public void addStudentWithCourses(@RequestBody Student student) {
        studentServiceInterface.addStudentWithCourses(student);
    }

    @GetMapping("/getStudentAndCourse/{studentId}")
    public List<Course> getStudentAndCourse(@PathVariable int studentId) {
         return studentServiceInterface.getStudentsAndCoursesByStudentId(studentId);
    }
}
