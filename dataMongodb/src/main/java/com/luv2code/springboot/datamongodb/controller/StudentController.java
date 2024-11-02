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

    @GetMapping("/id/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        return studentServiceInterface.getStudent(studentId);
    }

    @GetMapping({"/email/{studentEmail}"})
    public Student getStudentByEmail(@PathVariable String studentEmail) {
        return studentServiceInterface.getStudentByEmail(studentEmail);
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

    @PutMapping("/custom")
    public void updateStudent(@RequestParam String email ,@RequestParam String name) {
        studentServiceInterface.updateStudentEmail(email, name);
    }

}

