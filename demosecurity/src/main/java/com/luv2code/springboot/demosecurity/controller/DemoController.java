package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/showLoginForm")
    public String showLoginForm(){
        return "fancy-login";
    }

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/system")
    public String showSystem(){
        return "system";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied(){
        return "denyPage";
    }
}
