package com.luv2code.student.service;

import com.luv2code.student.repository.StudentDaoInterface;
import org.springframework.stereotype.Service;


public interface ServiceInterface {

     void deleteAllStudent(StudentDaoInterface studentDaoInterface) ;

     void deleteStudent(StudentDaoInterface studentDaoInterface) ;

     void updateStudentWithQuery(StudentDaoInterface studentDaoInterface);

     void updateStudent(StudentDaoInterface studentDaoInterface) ;

     void readByFirstName(StudentDaoInterface studentDaoInterface) ;

     void readAllStudent(StudentDaoInterface studentDaoInterface) ;

     void readStudent(StudentDaoInterface studentDaoInterface) ;

     void createMultipleStudent(StudentDaoInterface studentDaoInterface) ;

     void createStudent(StudentDaoInterface studentDaoInterface) ;
}
