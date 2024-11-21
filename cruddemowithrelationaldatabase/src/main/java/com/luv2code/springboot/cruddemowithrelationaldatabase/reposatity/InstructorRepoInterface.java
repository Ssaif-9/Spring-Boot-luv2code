package com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity;

import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.InstructorDto;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepoInterface extends JpaRepository<Instructor, Integer> {

    @Query("select i from Instructor i JOIN fetch i.courses where i.id = :theId")
    Instructor findInstructorByIdJoinFetch(@Param("theId") Integer theId);
}
