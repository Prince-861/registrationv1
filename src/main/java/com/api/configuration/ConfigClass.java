package com.api.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//By adding the @Configuration annotation, moment we will start this application, automatically this class will be loaded in the springboot and springboot will scan this class for what I have written.
//So, we want to tell the Springboot, that when ModelMapper is used this is the object you need to create.
@Configuration
public class ConfigClass {


//    @Bean annotation tells that when I start the project, the first set of files that will get loaded into the springboot before even any java code runs
//    because configuration class has the predefined details for the particular project.
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
//    After the config class runs then the service layer code runs which has the dependency injection code which we have mentioned.
}
