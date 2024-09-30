package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.exception.CustomException;
import com.luv2code.springboot.cruddemo.repository.EmployeeDAOInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeServiceInterface {

    private EmployeeDAOInterface employeeDAOInterface;

    @Autowired
    public EmployeeServiceImplement(EmployeeDAOInterface employeeDAOInterface) {
        this.employeeDAOInterface = employeeDAOInterface;
    }

    @Override
    public List<Employee> getAllEmployee() {
       return employeeDAOInterface.findAllEmployee();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee theEmployee = employeeDAOInterface.findEmployeeById(id);
        return theEmployee;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
       employeeDAOInterface.saveEmployee(employee);
       return employee;
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        employeeDAOInterface.updateEmployee(employee);
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAOInterface.deleteEmployee(id);
    }
}
