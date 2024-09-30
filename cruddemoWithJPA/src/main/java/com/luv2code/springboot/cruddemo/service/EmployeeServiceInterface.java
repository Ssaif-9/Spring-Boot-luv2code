package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

}
