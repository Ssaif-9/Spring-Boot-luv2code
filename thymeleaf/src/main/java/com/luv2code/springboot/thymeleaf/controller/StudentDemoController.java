package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentDemoController {

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String confirmStudentForm(@ModelAttribute("student") Student student) {
        return "confirmStudentForm";
    }
}
