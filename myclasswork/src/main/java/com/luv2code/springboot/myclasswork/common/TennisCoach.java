package com.luv2code.springboot.myclasswork.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println("In Constructor : "+getClass().getName());
    }

    public String getDailyWorkout() {
        return "Practical workout from tennis coach";
    }
}
