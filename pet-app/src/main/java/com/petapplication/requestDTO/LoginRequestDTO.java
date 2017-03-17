package com.petapplication.requestDTO;

import com.petapplication.utility.ModelBase;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author admin
 */
@Getter
@Setter
public class LoginRequestDTO extends ModelBase {

    @NotNull(message = "Can't be null.")
    @NotEmpty(message = "This field is required.")
    private String userName;

    @NotNull(message = "Can't be null.")
    @NotEmpty(message = "This field is required.")
    private String password;

}
