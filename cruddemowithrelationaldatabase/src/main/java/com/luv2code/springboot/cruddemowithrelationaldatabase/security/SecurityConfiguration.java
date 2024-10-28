package com.luv2code.springboot.cruddemowithrelationaldatabase.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/instructor/**").hasRole("ADMIN")
                        .requestMatchers("/instructordetail/**").hasAnyRole("ADMIN", "INSTRUCTOR")
                        .anyRequest()
                        .authenticated());

        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails saif = User.builder()
                .username("saif")
                .password("{noop}test123")
                .roles("ADMIN")
                .build();

        UserDetails sultan = User.builder()
                .username("sultan")
                .password("{noop}test123")
                .roles("INSTRUCTOR")
                .build();

        return new InMemoryUserDetailsManager(saif, sultan);
    }

}
