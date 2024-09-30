package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);

}
