package com.petapplication.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author admin
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handelGenericException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorMessage("Something Wrong Check Server Log.", ""), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DataBindingErrorMessage handelMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        return dataBindingErrorMessagesConverter(exception.getBindingResult());
    }

    public DataBindingErrorMessage dataBindingErrorMessagesConverter(BindingResult bindingResult) {
        DataBindingErrorMessage dataBindingErrorMessage = new DataBindingErrorMessage();
        dataBindingErrorMessage.setCode(HttpStatus.BAD_REQUEST.value());
        dataBindingErrorMessage.setErrorMessage("Invalid request parameters.");
        List<DataBindingErrorMessage.Error> errors = new ArrayList<>();
        dataBindingErrorMessage.setCode(HttpStatus.BAD_REQUEST.value());
        bindingResult.getFieldErrors().forEach(fieldError -> {
            System.out.println(fieldError);
            DataBindingErrorMessage.Error error = dataBindingErrorMessage.new Error();
            error.setErrorMessage(fieldError.getDefaultMessage());
            error.setRejectedValue(fieldError.getRejectedValue());
            error.setFieldName(fieldError.getField());
            errors.add(error);

        });
        dataBindingErrorMessage.setErrors(errors);
        return dataBindingErrorMessage;
    }
}
