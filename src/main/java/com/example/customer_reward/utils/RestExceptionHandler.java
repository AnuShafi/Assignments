package com.example.customer_reward.utils;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptionMethod(Exception ex, WebRequest request) {

    ServiceException exceptionMessageObj = new ServiceException();

     if(ex instanceof MethodArgumentNotValidException) {
        StringBuilder sb = new StringBuilder(); 
        List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        for(FieldError fieldError: fieldErrors){
            sb.append(fieldError.getDefaultMessage());
            sb.append(";");
        }
        exceptionMessageObj.setMessage(sb.toString());
    }else{
        exceptionMessageObj.setMessage(ex.getLocalizedMessage());
    }

    exceptionMessageObj.setError(ex.getClass().getCanonicalName());
  
    return new ResponseEntity<>(exceptionMessageObj, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
