package com.petapplication.exception;

import com.petapplication.utility.ModelBase;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
public class ErrorMessage extends ModelBase {

    private String message;

    private String code;

    public ErrorMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
