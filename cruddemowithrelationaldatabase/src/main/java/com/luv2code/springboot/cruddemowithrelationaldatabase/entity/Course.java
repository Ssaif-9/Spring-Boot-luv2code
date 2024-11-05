package com.luv2code.springboot.cruddemowithrelationaldatabase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;


    @ManyToMany( fetch = FetchType.LAZY,
                cascade = { CascadeType.PERSIST,CascadeType.DETACH,
                            CascadeType.MERGE,CascadeType.REFRESH }
                )
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Course(String title) {
        this.title = title;
    }

    public void addReview(Review tempReview) {
        if(reviews==null) {
            reviews=new ArrayList<>();
        }
        reviews.add(tempReview);
    }

    public void addStudent(Student tempStudent) {
        if(students==null) {
            students=new ArrayList<>();
        }
        students.add(tempStudent);
    }

}
