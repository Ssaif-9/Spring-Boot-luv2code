package com.luv2code.springboot.demosecurity.secutity;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(configurer->
                                    configurer
                                            .requestMatchers("/").hasRole("EMPLOYEE")
                                            .requestMatchers("/leaders/**").hasRole("MANAGER")
                                            .requestMatchers("/system/**").hasRole("ADMIN")
                                            .anyRequest()
                                            .authenticated())


                       .formLogin(form->
                                    form.loginPage("/showLoginForm")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll())
                       .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer->
                        configurer
                                .accessDeniedPage("/accessDenied"));

        return http.build();
    }
//    @Bean
//    public UserDetailsManager userDetails(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id ,pw,active  from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id ,role from roles where user_id=?");
        return userDetailsManager;
    }




//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//
//        UserDetails saif = User.builder()
//                .username("saif")
//                .password("{noop}12345")
//                .roles("ADMIN","MANAGER","EMPLOYEE")
//                .build();
//
//        UserDetails omar =User.builder()
//                .username("omar")
//                .password("{noop}12345")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails ahmed =User.builder()
//                .username("ahmed")
//                .password("{noop}12345")
//                .roles("MANAGER","EMPLOYEE")
//                .build();
//
//        return new InMemoryUserDetailsManager(saif,omar,ahmed);
//    }
}
