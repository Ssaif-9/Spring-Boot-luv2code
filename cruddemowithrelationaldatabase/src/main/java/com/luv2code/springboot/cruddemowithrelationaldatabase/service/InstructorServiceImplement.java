package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.dtoEntity.InstructorCourses;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Course;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Instructor;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Review;
import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.Student;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.CustomException;
import com.luv2code.springboot.cruddemowithrelationaldatabase.exception.GeneralException;
import com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity.InstructorRepoInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImplement implements InstructorServiceInterface{

    private final InstructorRepoInterface instructorRepo;

    public InstructorServiceImplement(InstructorRepoInterface instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepo.save(instructor);
    }

    @Override
    public void saveInstructorWithCourses(InstructorCourses instructorCourses) {

            Instructor instructor = instructorCourses.getInstructor();

            instructorCourses.getCourses().forEach(courseDetail -> {
                Course course = courseDetail.getCourse();

                // Associate course with instructor
                instructor.addCourse(new Course(course.getTitle()));
                // Add and associate reviews to the course
                courseDetail.getReviews().forEach(reviewData -> {
                    Review review = new Review(reviewData.getComment());
                    course.addReview(review);
                    // If Review needs to know its Course, set course in review here
                    // review.setCourse(course); // Uncomment if Review has a reference to Course
                });

                // Add and associate students to the course
                courseDetail.getStudents().forEach(studentData -> {
                    Student student = new Student(studentData.getFirstName(), studentData.getLastName(), studentData.getEmail());

                    // Establish bidirectional association
                    course.addStudent(student);
                    student.addCourse(course);
                });
            });

            // Persist the instructor, which should cascade to courses, reviews, and students
            instructorRepo.save(instructor);
        }

//        instructorCourses.getCourses().forEach(course -> {
//            course.getReviews().forEach(review -> {course.getCourse().addReview(new Review(review.getComment()));});
//            course.getStudents().forEach(student -> {course.getCourse().addStudent(new Student(student.getFirstName(),student.getLastName(),student.getEmail()));});
//                                                    instructorCourses.getInstructor().addCourse(new Course((course.getCourse().getTitle())));
//
//                                                }
//        );
//        instructorRepo.save(instructorCourses.getInstructor());

    @Override
    public Instructor findInstructorById(int id) {
        Optional<Instructor> instructorOptional =instructorRepo.findById(id);
        if(instructorOptional.isPresent())
            return instructorOptional.get();
        else
            throw new CustomException("505","Not Found ","Not Found Instructor with id : "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Instructor> findAllInstructors() {
       return instructorRepo.findAll();
    }


    @Override
    public void updateInstructor(Instructor instructor) {
        Optional<Instructor> instructorOptional =instructorRepo.findById(instructor.getId());
        if(instructorOptional.isPresent()){
            instructorOptional.get().setFirstName(instructor.getFirstName());
            instructorOptional.get().setLastName(instructor.getLastName());
            instructorOptional.get().setEmail(instructor.getEmail());
            instructorOptional.get().setInstructorDetail(instructor.getInstructorDetail());

            instructorRepo.save(instructorOptional.get());
        }
    }

    @Override
    public void deleteInstructorById(int id) {
        instructorRepo.deleteById(id);
    }
}
