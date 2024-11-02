package com.luv2code.springboot.datamongodb.reposiary;

import org.springframework.stereotype.Repository;


public interface CustomStudentRepoInterface {

    void updateStudentEmail(String email,String name);
}
