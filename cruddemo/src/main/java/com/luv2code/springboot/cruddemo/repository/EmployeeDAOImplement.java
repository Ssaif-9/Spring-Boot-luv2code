package com.luv2code.springboot.cruddemo.repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplement implements EmployeeDAOInterface {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployee() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employeesList =theQuery.getResultList();
        return employeesList;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee theEmployee =entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
      entityManager.persist(employee);
      return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }
}
