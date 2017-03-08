package com.petapplication.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author admin
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handelGenericException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorMessage("Something Wrong Check Server Log.", ""), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<DataBindingErrorMessage> handelMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        return dataBindingErrorMessagesConverter(exception.getBindingResult());
    }

    public List<DataBindingErrorMessage> dataBindingErrorMessagesConverter(BindingResult bindingResult) {
        List<DataBindingErrorMessage> errorMessages = new ArrayList<>();
        bindingResult.getAllErrors().forEach(fieldError -> {
            errorMessages.add(new DataBindingErrorMessage(fieldError.getObjectName(), fieldError.getDefaultMessage(), fieldError.getCode()));
        });
        return errorMessages;
    }
}
