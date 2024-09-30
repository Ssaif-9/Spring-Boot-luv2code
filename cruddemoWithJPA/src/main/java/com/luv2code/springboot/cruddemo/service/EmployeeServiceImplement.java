package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.exception.CustomException;
import com.luv2code.springboot.cruddemo.repository.EmployeeRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeServiceInterface {

    private EmployeeRepositoryInterface employeeRepositoryInterface;

    @Autowired
    public EmployeeServiceImplement(EmployeeRepositoryInterface employeeDAOInterface) {
        this.employeeRepositoryInterface = employeeDAOInterface;
    }

    @Override
    public List<Employee> getAllEmployee() {
       return employeeRepositoryInterface.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> theEmployee = employeeRepositoryInterface.findById(id);
        if (theEmployee.isPresent())
            return theEmployee.get();
        else
            throw new CustomException("404","NOT FOUND","Employee with id " + id + " not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepositoryInterface.save(employee);
       return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeRepositoryInterface.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepositoryInterface.deleteById(id);
    }
}
