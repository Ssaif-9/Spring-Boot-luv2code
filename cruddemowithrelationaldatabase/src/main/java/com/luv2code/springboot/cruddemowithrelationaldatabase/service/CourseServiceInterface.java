package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.CourseDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.CourseDto;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseServiceInterface {

    void addCourse(Course course);

    List<CourseDto> findAllCourse();

    Course findCourseById(Integer id);

    void deleteCourseById(Integer id);

    void updateCourse(Course course);

    void addCourseAndReview(Course course);

    void addCourseWithReviewAndStudent(Course course);

    List<CourseDetail> findCoursesWithInstructorId(Integer id);
}
