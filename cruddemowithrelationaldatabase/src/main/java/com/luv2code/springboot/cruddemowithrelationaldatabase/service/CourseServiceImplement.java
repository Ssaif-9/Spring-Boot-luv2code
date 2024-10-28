package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.CustomException;
import com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity.CourseRepoInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

@Service
@RequiredArgsConstructor
public class CourseServiceImplement implements CourseServiceInterface{

    private final CourseRepoInterface courseRepoInterface;

    @Override
    public void addCourse(Course course) {
        courseRepoInterface.save(course);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepoInterface.findAll();
    }

    @Override
    public Course findCourseById(Integer id) {
        Optional<Course> courseOptional=courseRepoInterface.findById(id);
        if(courseOptional.isPresent())
            return courseOptional.get();
        else
            throw new CustomException("404","Not Found ","Not Found Course With Id : " +id, HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseRepoInterface.deleteById(id);
    }

    @Override
    public void updateCourse(Course course) {
        Optional<Course> courseOptional=courseRepoInterface.findById(course.getId());
        if(courseOptional.isPresent()) {
            courseOptional.get().setTitle(course.getTitle());
            courseOptional.get().setInstructor(course.getInstructor());
            courseRepoInterface.save(courseOptional.get());
        }
        else
            throw new CustomException("404","Not Found ","Not Found Course With Id : " +course.getId(), HttpStatus.NOT_FOUND);
    }
}
