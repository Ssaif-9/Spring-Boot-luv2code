package com.luv2code.springboot.cruddemowithrelationaldatabase.controller;

import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.CourseDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.CourseDto;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.CourseServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceInterface courseServiceInterface;

    @GetMapping()
    public List<CourseDto> getAllCourses() {
        return courseServiceInterface.findAllCourse();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId) {
        return courseServiceInterface.findCourseById(courseId);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<CourseDetail> getCoursesByInstructorId(@PathVariable Integer instructorId){
        List<CourseDetail> courses = courseServiceInterface.findCoursesWithInstructorId(instructorId);
        System.out.println(courses);
        return courses;
    }

    @PostMapping()
    public void addCourse(@RequestBody Course course) {
        courseServiceInterface.addCourse(course);
    }

    @PostMapping("/review")
    public void addCourseAndReview(@RequestBody Course course) {
        courseServiceInterface.addCourseAndReview(course);
    }

    @PostMapping("/student")
    public void addCourseWithReviewAndStudent(@RequestBody Course course) {
        courseServiceInterface.addCourseWithReviewAndStudent(course);
    }

    @PutMapping()
    public void UpdateCourse(@RequestBody Course course) {
        courseServiceInterface.updateCourse(course);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Integer courseId) {
        courseServiceInterface.deleteCourseById(courseId);
    }


}
