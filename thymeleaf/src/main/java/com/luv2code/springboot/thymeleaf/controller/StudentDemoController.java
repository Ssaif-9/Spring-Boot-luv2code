package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentDemoController {

    @Value("${countries}")
    List<String> countries;

    @Value("${Language}")
    List<String> languages;

    @Value("${Systems}")
    List<String> systems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("systems", systems);
        return "studentForm";
    }

    @PostMapping("/processStudentForm")
    public String confirmStudentForm(@ModelAttribute("student") Student student) {
        return "confirmStudentForm";
    }
}
