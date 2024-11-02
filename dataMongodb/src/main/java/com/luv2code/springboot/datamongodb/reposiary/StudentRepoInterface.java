package com.luv2code.springboot.datamongodb.reposiary;

import com.luv2code.springboot.datamongodb.collection.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoInterface extends MongoRepository<Student, String> {

    @Query(value = "{email: '?0'}",fields = "{'name':1}")
    Student findStudentByEmail(String email);

}
