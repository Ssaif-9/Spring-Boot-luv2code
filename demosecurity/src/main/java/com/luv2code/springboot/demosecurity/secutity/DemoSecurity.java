package com.luv2code.springboot.demosecurity.secutity;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurity {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails saif = User.builder()
                .username("saif")
                .password("{noop}12345")
                .roles("ADMIN")
                .build();

        UserDetails omar =User.builder()
                .username("omar")
                .password("{noop}12345")
                .roles("EMPLOYEE")
                .build();

        UserDetails ahmed =User.builder()
                .username("ahmed")
                .password("{noop}12345")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(saif,omar,ahmed);
    }
}
