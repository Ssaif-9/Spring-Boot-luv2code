package com.luv2code.springboot.datamongodb.service;

import com.luv2code.springboot.datamongodb.collection.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentServiceInterface {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(String id);

    Student getStudent(String id);

    List<Student> getAllStudents();

}
