package com.petapplication.exception;

/**
 *
 * @author admin
 */
public class UnauthorizedExceptionHandler extends RuntimeException {

    public UnauthorizedExceptionHandler(String message) {
        super(message);
    }

}
