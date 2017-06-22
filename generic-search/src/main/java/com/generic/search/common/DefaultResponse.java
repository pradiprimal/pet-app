package com.generic.search.common;

import java.io.Serializable;

/**
 * Created by pradip on 6/22/17.
 * Email pradip@drac.com.np
 */
public class DefaultResponse implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
