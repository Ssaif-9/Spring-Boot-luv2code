package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Student;
import com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity.StudentRepoInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentServiceInterface{

    private final StudentRepoInterface studentRepoInterface;

    @Override
    public void addStudent(Student student) {
        studentRepoInterface.save(student);
    }

    @Override
    public void addStudentWithCourses(Student student) {
        student.addCourse(new Course("os"));
        student.addCourse(new Course("windows"));

        studentRepoInterface.save(student);
    }

    @Override
    public List<Course> getStudentsAndCoursesByStudentId(Integer id) {
        return studentRepoInterface.findStudentAndCourseByStudentId(id);
    }
}
