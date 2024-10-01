package com.api.exception;

import com.api.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

// @Controller acts as a mediator between view and the backend business logic.
// @RestController helps us to build an api in the SpringBoot.
// @ControllerAdvice helps us to handle the exception.

@ControllerAdvice
public class GlobalExceptionHandler {
//    Whatever exception will come here, this method will suppress that exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> resourceNotFound(ResourceNotFoundException r, WebRequest request){
//        WebRequest will automatically get the object address from the SpringBoot
//        WebRequest request will help us to understand from where the webRequest was made and this exception was thrown, which url sends this request to backend and this error is thrown.
//        ResourceNotFoundException r, by writing this we are mentioning which exception object address it has to hold.
        ErrorDto error = new ErrorDto(r.getMessage(), new Date(), request.getDescription(false));//by mentioning false here, we are hiding the client(here Postman) address here.
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//  All other exception except ResourceNotFoundException will be handled by this handleGlobalException method
//    So there are two types to handle the exception, using specific exception and by using globalException
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
