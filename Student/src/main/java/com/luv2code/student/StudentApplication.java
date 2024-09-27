package com.luv2code.student;

import com.luv2code.student.repository.StudentDaoInterface;
import com.luv2code.student.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class StudentApplication {

    private final ServiceInterface serviceInterface;

    @Autowired
    public StudentApplication(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner (StudentDaoInterface studentDaoInterface) {
        return running -> {
           // serviceInterface.createStudent(studentDaoInterface);
           // serviceInterface.createMultipleStudent(studentDaoInterface);
           // serviceInterface.readStudent(studentDaoInterface);
           // serviceInterface.readAllStudent(studentDaoInterface);
            // serviceInterface.readByFirstName(studentDaoInterface);
           // serviceInterface.updateStudent(studentDaoInterface);
           // serviceInterface.updateStudentWithQuery(studentDaoInterface);
           // serviceInterface.deleteStudent(studentDaoInterface);
            //serviceInterface.deleteAllStudent(studentDaoInterface);

        };
    }
}
