package com.luv2code.student;

import com.luv2code.student.entity.Student;
import com.luv2code.student.repository.StudentDaoInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (StudentDaoInterface studentDaoInterface) {
        return running -> {
           // createStudent(studentDaoInterface);
           // createMultipleStudent(studentDaoInterface);
           // readStudent(studentDaoInterface);
           // readAllStudent(studentDaoInterface);
           // readByFirstName(studentDaoInterface);
           // updateStudent(studentDaoInterface);
           // updateStudentWithQuery(studentDaoInterface);
           // deleteStudent(studentDaoInterface);
            deleteAllStudent(studentDaoInterface);

        };
    }

    private void deleteAllStudent(StudentDaoInterface studentDaoInterface) {
        System.out.println(studentDaoInterface.deleteAllStudents());
    }

    private void deleteStudent(StudentDaoInterface studentDaoInterface) {
            studentDaoInterface.deleteStudentById(8L);
    }

    private void updateStudentWithQuery(StudentDaoInterface studentDaoInterface) {
          int noOfChange = studentDaoInterface.updateStudent("Osama");
        System.out.println(noOfChange);
    }

    private void updateStudent(StudentDaoInterface studentDaoInterface) {
         Optional<Student>student = studentDaoInterface.getStudentById(1);
        if (student.isPresent()) {
            student.get().setFirstName("salah");
            studentDaoInterface.updateStudent(student.get());
         }
    }
    private void readByFirstName(StudentDaoInterface studentDaoInterface) {
       Optional< List<Student>> students = studentDaoInterface.getStudentByFirstName("amar");
       if(students.isPresent()) {
               System.out.println(students.toString());
           }
       else
           System.out.println("No students found");
       }


    private void readAllStudent(StudentDaoInterface studentDaoInterface) {
        List<Student> students = studentDaoInterface.getAllStudents();
        for(Student student : students) {
            System.out.println(student.toString());
        }
    }

    private void readStudent(StudentDaoInterface studentDaoInterface) {
      Optional<Student> student =  studentDaoInterface.getStudentById(5);
        System.out.println(student.toString());
    }

    private void createMultipleStudent(StudentDaoInterface studentDaoInterface) {
        Student student1 = new Student("omar","zaki","omar@gmail.com ");
        Student student2 = new Student("ahmed","sherif","ahmed@gmail.com ");
        Student student3 = new Student("abdelrahman","hassan","abdo@gmail.com ");
        studentDaoInterface.save(student1);
        studentDaoInterface.save(student2);
        studentDaoInterface.save(student3);
    }

    public void createStudent(StudentDaoInterface studentDaoInterface) {
        Student student = new Student("Seif","Sultan","saifsoltan18@gmail.com ");
        studentDaoInterface.save(student);
    }
}
