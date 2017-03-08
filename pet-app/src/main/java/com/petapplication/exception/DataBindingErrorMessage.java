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
public class DataBindingErrorMessage extends ModelBase {

    private final String fieldName;

    private final String errorMessage;

    private final String rejectedValue;

    public DataBindingErrorMessage(String fieldName, String errorMessage, String rejectedValue) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.rejectedValue = rejectedValue;
    }

}
