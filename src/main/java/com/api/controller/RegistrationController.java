package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController will make an api layer
//Whenever we will call this class, we will use this url
//everytime we build an application there are different-different versions of it
//in version 1 we develop something and in version 2 we implement something.
//so, mentioning version tells us which version of application is this?
//and mentioning api tells us that this is not the ordinary url, it is an api url
//api helps us to integrate and exchange the data between two items.
@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

//    -----------DATA RETRIEVAL-----------

//    In order to get all the data from the database(when we read the data from the database, it is actually the java object) and to put it into the json object, we use @GetMapping
//    Java Objects gets converted to json object using GetMapping
//    Since it is controller layer, then it will call the service layer from here
    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
//        do not return the response directly as an Entity object.
//        whenever we return the response back to the postman, put that data into the dto and return the data back.
        List<RegistrationDto> dtos = registrationService.getRegistrations();
//        return registrations;//here we have java objects only, but when we will return java objects from here @GetMapping will convert that java objects into the json object and the end result we will see is the json object only.
        return new ResponseEntity<>(dtos, HttpStatus.CREATED);//to return the right response status.
    }


//  ------------ DATA CREATION-----------


//    @PostMapping is used to save the data into the database.
//    http://localhost:8080/api/v1/registration from this url, it will call the below method in the controller from the postman, and through this url, we have to supply the data to the controller and the data that will be supplied, it will be the JSON.

//    -------------------------------------------------------------------------
//    @PostMapping
//    public ResponseEntity<Registration>createRegistration(@RequestBody Registration registration){
////   through this url http://localhost:8080/api/v1/registration in the postman, the json data will come to the given object registration.
////    in order to copy the data from the json to this object(registration), we use the @RequestBody annotation
////    once the data is copied, take that data and give it to the service layer
//        Registration reg = registrationService.createRegistration(registration);
//        return new ResponseEntity<>(reg,HttpStatus.CREATED);
//    }


//    -------------------------------------------------

//  If I don't want to return the whole entity and I want to return the data of my choice, so here we will use RegistrationDto and not the Registration entity
//    We can't club the data coming from the three tables and store into one object using entity
//    Sometimes data used to come from the three(multiple) tables in backend, so we will club all the three data in dto object and return back as the response.So, here dto becomes very useful.
//    Sometimes we want to save the data into multiple tables, so in that case we will take the data into the dto and save the data according to our need.


//    Below if we do not apply the @Valid annotation then Spring Validation will not work on the below object.
//    @Valid annotation is ensuring that the data going to this object, firstly  we are validating this with the validator of hibernate, and if everything is correct then we are moving further.
//    If it is having some kind of error then we will use one class(BindingResult) to capture that error
    @PostMapping
    public ResponseEntity<?> createRegistration(@Valid @RequestBody RegistrationDto registrationDto, BindingResult result){
//        when there are multiple types of data we are returning from a method then we should change the return type, either we should make this public ResponseEntity<Object>, or  we should use the ? here, public ResponseEntity<?>
//        because this will return either string or error
//        and this will return dto return new ResponseEntity<>(regDto, HttpStatus.CREATED), so multiple type of data we are returning.
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }

        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);//so from here it will return the Dto object that will be sent to the postman as the response.
    }

//    -- how many endpoints, how many web services, how many api's you have created, everything is same here

//    -------------DATA DELETION--------------
//  @DeleteMapping Annotation helps us to delete the record in the database
    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(@RequestParam long id){
//      to read the value from the url and initialize this id variable, we use @RequestParam annotation
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);//status code for the deletion is OK(and it is 200).
    }

//    ------------DATA UPDATION------------
//  @PutMapping helps us to update the record in the database using the API.
//     @PutMapping("/{id}"), it will help us to get the value from the url
    @PutMapping("/{id}")
    public ResponseEntity<Registration>updateRegistration(@PathVariable long id, @RequestBody Registration registration){
//        @PathVariable helps us in how values are supplied in the url as a path parameter and not the query parameter.
//        For the information to be updated, we have used the @RequestBody annotation
          Registration updateReg = registrationService.updateRegistration(id,registration); //so the data that needs to be updated will come here from the service layer
//        so we need to return that information to the postman
          return new ResponseEntity<>(updateReg, HttpStatus.OK);

    }

//    --------------getting registration by Id
//    We can have ambiguity, if we give the @GetMapping(or annotation multiple times and don't change the url) because the same url will try to call the multiple methods.
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(@PathVariable long id){
        RegistrationDto dto = registrationService.getRegistrationById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}
