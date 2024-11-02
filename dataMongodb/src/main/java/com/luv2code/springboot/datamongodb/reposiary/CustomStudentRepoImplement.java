package com.luv2code.springboot.datamongodb.reposiary;
import com.luv2code.springboot.datamongodb.collection.Student;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CustomStudentRepoImplement implements CustomStudentRepoInterface{

    private final MongoTemplate mongoTemplate;

    public CustomStudentRepoImplement(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void updateStudentEmail(String email,String name) {

        Query query=new Query(Criteria.where("email").is(email));
        Update update=new Update();
        update.set("name", name);

        UpdateResult result=mongoTemplate.updateFirst(query,update,Student.class);

    }
}
