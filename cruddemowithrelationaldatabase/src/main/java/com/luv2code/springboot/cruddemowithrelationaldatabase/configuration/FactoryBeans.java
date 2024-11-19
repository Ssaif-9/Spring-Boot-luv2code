package com.luv2code.springboot.cruddemowithrelationaldatabase.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeans {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
