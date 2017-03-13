package com.petapplication.responseDTO;

import com.petapplication.utility.ModelBase;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
public class SingleValueResponse extends ModelBase {

    private String message;

    public SingleValueResponse(String message) {
        this.message = message;
    }

}
