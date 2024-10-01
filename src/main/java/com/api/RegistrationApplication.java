package com.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//All the project in SpringBoot starts from this class (SpringBootApplication) and it is the root class in which the main method is present.
//This class is the starting point of our SpringBootApplication
//SpringBootApplication class can also be used as the Configuration class.
@SpringBootApplication
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

//	Whenever dependency injection is not happening for some reason like IOC doesn't know which object to create then we can use @Bean annotation
//	For Example, I want to copy data from dto to entity and entity to dto, so in our project we have used ModelMapper library
//	When we try to do the dependency injection for the ModelMapper library we get a message error creating a bean
//	We got this message because IOC was unable to create an object for this particular class.
//	So I had to configure stating which object to be created for this reference variable
//	We have used @Bean annotation, because of which now dependency injection is performed and Spring IOC knows which object to create.
//	@Bean
//	public ModelMapper getModelMapper(){
//		return new ModelMapper();
//	}

}
