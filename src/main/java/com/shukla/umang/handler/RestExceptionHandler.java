package com.shukla.umang.handler;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shukla.umang.dto.error.ErrorDetail;
import com.shukla.umang.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    /**
     * To standardize the way in which api errors are return across the whole project
     * we are adding a exception handler which will return a object of the ErrorDetail
     * class whenever a ResourceNotFoundException exception is thrown.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException
        rnfe, HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Resource Not Found");
        errorDetail.setDetail(rnfe.getMessage());
        errorDetail.setDeveloperMessage(rnfe.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }

}
