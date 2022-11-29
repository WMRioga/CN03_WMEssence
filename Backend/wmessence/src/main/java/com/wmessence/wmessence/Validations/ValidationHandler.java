package com.wmessence.wmessence.Validations;

import com.wmessence.wmessence.Models.ErrorModel;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity <Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        ArrayList <ErrorModel> errors = new ArrayList<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            ErrorModel err = new ErrorModel();
            err.setField(((FieldError) error).getField());
            err.setMessage(error.getDefaultMessage());
            errors.add(err);
        });
        return new ResponseEntity<Object>(errors, HttpStatus.PARTIAL_CONTENT);
    }
}
