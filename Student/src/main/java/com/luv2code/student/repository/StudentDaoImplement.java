package com.luv2code.student.repository;

import com.luv2code.student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImplement implements StudentDaoInterface {


    private EntityManager entityManager;

    @Autowired
    public StudentDaoImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return Optional.of(Optional.ofNullable(entityManager.find(Student.class, id)).orElse(new Student()));
    }

    @Override
    public Optional<List<Student>> getStudentByFirstName(String firstNameArgument) {
        Query theQuery = entityManager.createQuery("From Student where firstName=:first");
        theQuery.setParameter("first", firstNameArgument);
        List<Student> students = theQuery.getResultList();
        //return Optional.ofNullable(students).orElse(new ArrayList<>());
        return students.isEmpty() ? Optional.empty() : Optional.of(students);
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("from Student order by lastName", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student){
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateStudent(String lastNameArgument) {
        int numOfChange = entityManager.createQuery("UPDATE Student s SET s.lastName = :last WHERE s.firstName = 'ahmed'").setParameter("last", lastNameArgument).executeUpdate();
        return numOfChange;
    }

    @Override
    @Transactional
    public void deleteStudentById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
       int noOfModify= entityManager.createQuery("delete from Student").executeUpdate();
        return noOfModify;
    }
}
