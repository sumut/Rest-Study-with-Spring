package com.sumutella.reststudy.restcontrollers;

import com.sumutella.reststudy.entities.ErrorResponseEntity;
import com.sumutella.reststudy.exceptionhandling.EntityNotFoundException;
import com.sumutella.reststudy.exceptionhandling.IncorrectRestParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author sumutella
 * @time 3:38 PM
 * @since 11/24/2019, Sun
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseEntity> handleEntityNotFoundException(EntityNotFoundException enfe){
        ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
        errorResponseEntity.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponseEntity.setMessage(enfe.getMessage());
        return new ResponseEntity<>(errorResponseEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseEntity> handleIncorrectRestParameterException(IncorrectRestParameterException irpe){
        ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
        errorResponseEntity.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseEntity.setMessage(irpe.getMessage());
        return new ResponseEntity<>(errorResponseEntity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponseEntity> handleNoHandlerFoundException(NoHandlerFoundException nhfe){
        ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
        errorResponseEntity.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponseEntity.setMessage(nhfe.getMessage());
        return new ResponseEntity<>(errorResponseEntity, HttpStatus.BAD_REQUEST);
    }
}
