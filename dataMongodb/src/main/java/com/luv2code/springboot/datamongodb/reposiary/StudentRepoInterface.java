package com.luv2code.springboot.datamongodb.reposiary;

import com.luv2code.springboot.datamongodb.collection.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoInterface extends MongoRepository<Student, String> {

}
