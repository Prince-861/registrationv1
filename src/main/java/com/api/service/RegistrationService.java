package com.api.service;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;

//    If we want to run this project then then dependency injection for this object will not happen because in order to create an object spring IOC should know which object to create
//    If Spring IOC does not know which object to create then we get the error stating error creating in bean.
//    So, whenever we added an external library, that external library class objects to create through dependency injection will not happen automatically
//    If we will start this application then it will show the error because spring IOC does not know which object address to create and inject into this reference variable.
//    It's not like dependency injection can create every object it wants, it has limited object to be created information with it.
//    Since Spring IOC does not have idea that which object to create here, so as a developer we have to define which object to create.

//    ModelMapper is an object mapping library which copies data from one object to another but the object needs to be similar while copying the data.
//    @RestController annotation used to develop an api but @Controller layer acts as the controller layer between view and the backend business logic.
    private ModelMapper modelMapper;// to use this class we have added an external library from MVN repository



    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;

        this.modelMapper = modelMapper;
    }

//    public List<Registration> getRegistrations(){
//        List<Registration> registrations = registrationRepository.findAll();
//        return registrations;
//    }

    public List<RegistrationDto> getRegistrations(){
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos = registrations.stream().map(r->mapToDto(r)).collect(Collectors.toList());
        return dtos;
    }
//----------------------------------------------------

//    The job of this method to save the data into the database
//    public Registration createRegistration(Registration registration) {
//        Registration savedEntity = registrationRepository.save(registration);
//        return savedEntity;
//    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto){
//        since we are taking data into the registrationDto here so if we want to send the data to the database it can be send through the entity object data.

//        -----------copy dto to entity--------------
//        Registration registration = new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//        registration.setMobile(registrationDto.getMobile());
        Registration registration = mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);//using this we are saving the data into the database.


//      ------------copy entity to dto-----------------
//        RegistrationDto  dto = new RegistrationDto();
//        dto.setName(savedEntity.getName());
//        dto.setEmail(savedEntity.getEmail());
//        dto.setMobile(savedEntity.getMobile());
        RegistrationDto dto = mapToDto(savedEntity);

        return dto;
    }

    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
    }

    public Registration updateRegistration(long id, Registration registration) {
//        whatever data needs to be updated is present in the registration object in the parameter
        Registration r = registrationRepository.findById(id).get();//get() method will convert this into the Registration object
        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration savedEntity = registrationRepository.save(r);
        return savedEntity;
    }

    Registration mapToEntity(RegistrationDto registrationDto){
//        We don't have to write this much of code because it will be too lengthy when we have too many fields like name, email, city, address etc. So, better to use the ModelMapper map method();
        Registration registration = modelMapper.map(registrationDto, Registration.class);//The data to be copied from the registrationDto and it should be stored into the Registration.class.

//        Registration registration = new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//        registration.setMobile(registrationDto.getMobile());

        return registration;
    }

    RegistrationDto mapToDto(Registration registration ){
        RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);
//        RegistrationDto dto = new RegistrationDto();
//        dto.setName(registration.getName());
//        dto.setEmail(registration.getEmail());
//        dto.setMobile(registration.getMobile());
        return dto;
    }

    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record not found")
        );// here we are using Supplier(it does not take the input, it simply produces output)functional interface, here we are throwing the exception and not handling the exception
        return mapToDto(registration);
    }
}
