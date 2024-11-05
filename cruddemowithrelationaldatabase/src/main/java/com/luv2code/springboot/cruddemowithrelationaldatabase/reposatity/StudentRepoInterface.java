package com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepoInterface extends JpaRepository<Student, Integer> {

    @Query("select s from Student s join fetch s.courses where s.id = :studentId")
    List<Course> findStudentAndCourseByStudentId(@Param("studentId") Integer studentId);
}
