//package com.luv2code.springboot.cruddemo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DemoSecurityConfiguration {
//
////    /*
////    /**   default tables (users and authories)
////   */ @Bean
////    public UserDetailsManager userDetailsManager(DataSource dataSource) {
////        return new JdbcUserDetailsManager(dataSource);
////    }
////
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
//        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id , role from roles where user_id=?");
//        return userDetailsManager;
//    }
//
////    @Bean
////    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
////
////        UserDetails saif= User.builder()
////                .username("saif")
////                .password("{noop}test123")
////                .roles("ADMIN","MANAGER","EMPLOYEE")
////                .build();
////
////        UserDetails ahmed= User.builder()
////                .username("ahmed")
////                .password("{noop}test123")
////                .roles("MANAGER","EMPLOYEE")
////                .build();
////
////        UserDetails mazen= User.builder()
////                .username("mazen")
////                .password("{noop}test123")
////                .roles("EMPLOYEE")
////                .build();
////
////        return new InMemoryUserDetailsManager(saif,ahmed,mazen);
////    }
////
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("Manager")
//                        .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN"));
//
//        http.httpBasic(Customizer.withDefaults());
//
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
//}
