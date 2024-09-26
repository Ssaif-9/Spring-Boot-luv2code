package com.luv2code.student.repository;

import com.luv2code.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDaoInterface {

    void save(Student student);

    Optional<Student> getStudentById(int id);

    Optional<List<Student>> getStudentByFirstName(String firstName);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    int updateStudent(String lastNameArgument);

    void deleteStudentById(Long id);

    int deleteAllStudents();


}
