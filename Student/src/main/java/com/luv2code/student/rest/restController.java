package com.luv2code.student.rest;

import com.luv2code.student.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class restController {

    private List<Student> students ;

    @PostConstruct
    public void loadData() {
        students=new ArrayList<>();
        students.add(new Student(1L,"SAIF","SULTAN","saifsultan@gmail.com"));
        students.add(new Student(2L,"ahmed","saber","ahmedsaber@gmail.com"));
        students.add(new Student(3L,"mazen","nasser","mazzennasser@gmail.com"));
        students.add(new Student(2L,"ahmed","sherif","ahmedsherif@gmail.com"));
    }

    @GetMapping("/student")
    public List<Student> getStudents (){
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if( (studentId>=students.size()) | studentId<0 )
             throw new StudentNotFoundException("not found Student - " + studentId);
        return students.stream().filter(student-> Objects.equals(student.getLastName(), "sherif")).findFirst().get();
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
