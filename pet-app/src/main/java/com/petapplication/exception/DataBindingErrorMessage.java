package com.petapplication.exception;

import com.petapplication.utility.ModelBase;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
public class DataBindingErrorMessage extends ModelBase {

    private String errorMessage;

    private int code;

    List<Error> errors;

    class Error {

        private String fieldName;

        private String errorMessage;

        private Object rejectedValue;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public Object getRejectedValue() {
            return rejectedValue;
        }

        public void setRejectedValue(Object rejectedValue) {
            this.rejectedValue = rejectedValue;
        }

    }
}
