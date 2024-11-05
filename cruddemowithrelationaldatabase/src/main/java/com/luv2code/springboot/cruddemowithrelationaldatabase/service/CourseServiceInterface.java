package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseServiceInterface {

    void addCourse(Course course);

    List<Course> findAllCourse();

    Course findCourseById(Integer id);

    void deleteCourseById(Integer id);

    void updateCourse(Course course);

    void addCourseAndReview(Course course);

    void addCourseWithReviewAndStudent(Course course);

}
