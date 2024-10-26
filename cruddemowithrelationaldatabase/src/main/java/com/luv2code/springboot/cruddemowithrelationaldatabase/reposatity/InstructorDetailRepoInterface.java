package com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepoInterface extends JpaRepository<InstructorDetail, Integer> {

}
