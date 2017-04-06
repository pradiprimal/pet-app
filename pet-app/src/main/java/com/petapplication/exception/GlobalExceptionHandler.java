package com.petapplication.exception;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.petapplication.responseDTO.SingleValueResponse;
import io.jsonwebtoken.ExpiredJwtException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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
    public ResponseEntity<ErrorMessage> handleGenericException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorMessage("Something Wrong Check Server Log.", ""), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DataBindingErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        return dataBindingErrorMessagesConverter(exception.getBindingResult());
    }

    @ExceptionHandler(ContentConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public SingleValueResponse handleContentConflictException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        SingleValueResponse singleValueResponse = new SingleValueResponse(runtimeException.getMessage());
        return singleValueResponse;
    }

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SingleValueResponse handleContentNotFoundException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        SingleValueResponse singleValueResponse = new SingleValueResponse(runtimeException.getMessage());
        return singleValueResponse;
    }

    @ExceptionHandler(OperationFailedException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public SingleValueResponse handleOperationFailedException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        SingleValueResponse valueResponse = new SingleValueResponse(runtimeException.getMessage());
        return valueResponse;
    }

    @ExceptionHandler(UnauthorizedExceptionHandler.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SingleValueResponse handleUnauthorizedResourceAccess(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        SingleValueResponse singleValueResponse = new SingleValueResponse(runtimeException.getMessage());
        return singleValueResponse;
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SingleValueResponse handleExpiredJwtException(RuntimeException exception) {
        exception.printStackTrace();
        SingleValueResponse singleValueResponse = new SingleValueResponse("Token Expired");
        return singleValueResponse;
    }

    @ExceptionHandler({SQLException.class,DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public SingleValueResponse handleConstraintViolationException(Exception exception) {
        System.out.println("============Called!!!!!!!!===============");
        exception.printStackTrace();
        SingleValueResponse singleValueResponse = new SingleValueResponse(exception.getMessage());
        return singleValueResponse;
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
