package com.luv2code.springboot.myclasswork.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

    public HockeyCoach(){
        System.out.println("In Constructor : "+getClass().getName());
    }

    @PostConstruct
    public void init(){
        System.out.println("custom start !!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("custom destroy !!");
    }

    @Override
    public String getDailyWorkout() {
        return "Practical Coach workout from hockey coach";
    }
}
