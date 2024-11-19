package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.InstructorDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorDetailServiceInterface {

//    void saveInstructorDetail(InstructorDetail instructorDetail);

    InstructorDetail findInstructorDetailById(int id);

    List<InstructorDetail> findAllInstructorDetails();

    void updateInstructorDetail(InstructorDetail instructorDetail);

    void deleteInstructorDetailById(int id);
}
