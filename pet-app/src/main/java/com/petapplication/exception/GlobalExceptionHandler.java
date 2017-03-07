package com.petapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author admin
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handelGenericException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorMessage("Something Wrong Check Server Log", ""),HttpStatus.EXPECTATION_FAILED);
    }
}