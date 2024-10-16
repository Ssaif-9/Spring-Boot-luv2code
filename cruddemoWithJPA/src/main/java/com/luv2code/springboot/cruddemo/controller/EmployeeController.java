package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")

public class EmployeeController {

    private EmployeeServiceInterface employeeServiceInterface;

    public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
        this.employeeServiceInterface = employeeServiceInterface;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> listEmployee =employeeServiceInterface.getAllEmployee();
        model.addAttribute("employees", listEmployee);
        return "EmployeeList";
    }

    @GetMapping("/add")
    public String addEmployeeForm(Model model){
        model.addAttribute("employees", new Employee());
        return "addForm";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeServiceInterface.saveEmployee(employee);
        return "redirect:list";
    }

    @GetMapping("/update")
    public String updateEmployeeForm(@RequestParam("employeeId") int employeeId,Model model){
        Employee employee = employeeServiceInterface.getEmployeeById(employeeId);
        model.addAttribute("employees",employee );
        return "addForm";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId){
        employeeServiceInterface.deleteEmployee(employeeId);
        return "redirect:list";
    }
}
