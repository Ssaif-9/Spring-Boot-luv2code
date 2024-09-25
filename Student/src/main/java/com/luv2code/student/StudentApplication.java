package com.luv2code.student;

import com.luv2code.student.entity.Student;
import com.luv2code.student.repository.StudentDaoInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (StudentDaoInterface studentDaoInterface) {
        return running -> {
           // createStudent(studentDaoInterface);
            createMultipleStudent(studentDaoInterface);
        };
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
