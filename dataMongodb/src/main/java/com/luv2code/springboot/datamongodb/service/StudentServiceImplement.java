package com.luv2code.springboot.datamongodb.service;

import com.luv2code.springboot.datamongodb.collection.Student;
import com.luv2code.springboot.datamongodb.reposiary.StudentRepoInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentServiceInterface{

    private final StudentRepoInterface studentRepoInterface;
    @Override
    public void addStudent(Student student) {
        studentRepoInterface.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepoInterface.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepoInterface.deleteById(id);
    }

    @Override
    public Student getStudent(String id) {
        return studentRepoInterface.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepoInterface.findAll();
    }
}
