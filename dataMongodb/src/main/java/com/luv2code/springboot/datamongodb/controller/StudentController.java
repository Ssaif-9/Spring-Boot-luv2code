package com.luv2code.springboot.datamongodb.controller;

import com.luv2code.springboot.datamongodb.collection.Student;
import com.luv2code.springboot.datamongodb.service.StudentServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentServiceInterface studentServiceInterface;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentServiceInterface.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        return studentServiceInterface.getStudent(studentId);
    }

    @PostMapping()
    public void addStudent(@RequestBody Student student) {
        studentServiceInterface.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable String studentId) {
        studentServiceInterface.deleteStudent(studentId);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student) {
        studentServiceInterface.updateStudent(student);
    }

}

