package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;

@Controller
public class HelloDemoController {


    @RequestMapping("/showForm")
    public String demoPage() {
        return "HelloWorld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "HelloWorld";
    }

//    @RequestMapping("/processFormViaModel")
//    public String processFormViaModel(HttpServletRequest http, Model model) {
//        String studentName = http.getParameter("studentName");
//        studentName=studentName.toUpperCase();
//        String Message = "Yo!"+ studentName;
//        model.addAttribute("NAME", Message);
//        return "HelloWorld";
//    }

    @RequestMapping("/processFormViaModel")
    public String processFormViaModelAndRequestParam(@RequestParam("studentName") String name, Model model) {
        name=name.toUpperCase();
        String Message = "Yooo !"+ name;
        model.addAttribute("NAME", Message);
        return "HelloWorld";
    }


}
