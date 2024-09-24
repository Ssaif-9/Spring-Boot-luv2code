package com.luv2code.springboot.myclasswork.controller;

import com.luv2code.springboot.myclasswork.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    final private Coach coach;
    @Autowired
    public FunRestController(@Qualifier("hockeyCoach")Coach theCoach) {
        System.out.println("In Constructor" + getClass().getName());
        this.coach = theCoach;
    }

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return coach.getDailyWorkout() + " " + teamName;
    }

}
