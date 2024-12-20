package com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepoInterface extends JpaRepository<Course, Integer> {

    List<Course> findByInstructorId(Integer instructorId);

}
