package com.luv2code.springboot.cruddemo.restcontroller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.exception.CustomException;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeServiceInterface employeeServiceInterface;

    @Autowired
    public EmployeeRestController(EmployeeServiceInterface employeeServiceInterface) {
        this.employeeServiceInterface = employeeServiceInterface;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
       return employeeServiceInterface.getAllEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employeeServiceInterface.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee (@RequestBody Employee theEmployee) {
        employeeServiceInterface.saveEmployee(theEmployee);
        theEmployee.setId(0);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        employeeServiceInterface.updateEmployee(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        employeeServiceInterface.deleteEmployee(employeeId);
        return "Employee " + employeeId + " deleted successfully";
    }
}
