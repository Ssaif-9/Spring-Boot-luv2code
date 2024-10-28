package com.luv2code.springboot.cruddemowithrelationaldatabase.controller;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.service.CourseServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceInterface courseServiceInterface;

    @GetMapping()
    public List<Course> getAllCourses() {
        return courseServiceInterface.findAllCourse();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId) {
        return courseServiceInterface.findCourseById(courseId);
    }

    @PostMapping()
    public void addCourse(@RequestBody Course course) {
        courseServiceInterface.addCourse(course);
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
