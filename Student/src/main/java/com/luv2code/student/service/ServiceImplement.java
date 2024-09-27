package com.luv2code.student.service;

import com.luv2code.student.entity.Student;
import com.luv2code.student.repository.StudentDaoInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImplement implements ServiceInterface {

    @Override
    public void deleteAllStudent(StudentDaoInterface studentDaoInterface) {
        System.out.println(studentDaoInterface.deleteAllStudents());
    }

    @Override
    public void deleteStudent(StudentDaoInterface studentDaoInterface) {
        studentDaoInterface.deleteStudentById(8L);
    }

    @Override
    public void updateStudentWithQuery(StudentDaoInterface studentDaoInterface) {
        int noOfChange = studentDaoInterface.updateStudent("Osama");
        System.out.println(noOfChange);
    }

    @Override
    public void updateStudent(StudentDaoInterface studentDaoInterface) {
        Optional<Student> student = studentDaoInterface.getStudentById(1);
        if (student.isPresent()) {
            student.get().setFirstName("salah");
            studentDaoInterface.updateStudent(student.get());
        }
    }

    @Override
    public void readByFirstName(StudentDaoInterface studentDaoInterface) {
        Optional<List<Student>> students = studentDaoInterface.getStudentByFirstName("saif");
        if(students.isPresent()) {
            System.out.println(students.toString());
        }
        else
            System.out.println("No students found");
    }

    @Override
    public void readAllStudent(StudentDaoInterface studentDaoInterface) {
        List<Student> students = studentDaoInterface.getAllStudents();
        for(Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Override
    public void readStudent(StudentDaoInterface studentDaoInterface) {
        Optional<Student> student =  studentDaoInterface.getStudentById(5);
        System.out.println(student.toString());
    }

    @Override
    public void createMultipleStudent(StudentDaoInterface studentDaoInterface) {
        Student student1 = new Student("omar","zaki","omar@gmail.com ");
        Student student2 = new Student("ahmed","sherif","ahmed@gmail.com ");
        Student student3 = new Student("abdelrahman","hassan","abdo@gmail.com ");
        studentDaoInterface.save(student1);
        studentDaoInterface.save(student2);
        studentDaoInterface.save(student3);
    }

    @Override
    public void createStudent(StudentDaoInterface studentDaoInterface) {
        Student student = new Student("Seif","Sultan","saifsoltan18@gmail.com ");
        studentDaoInterface.save(student);
    }
}
