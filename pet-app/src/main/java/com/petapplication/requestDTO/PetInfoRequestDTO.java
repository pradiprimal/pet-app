package com.petapplication.requestDTO;

import com.petapplication.utility.ModelBase;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

@Getter
@Setter
public class PetInfoRequestDTO extends ModelBase {

    private Long id;

//    @NotEmpty(message = "Dog name field can't be empty")
    @Size(min = 2, max = 50, message = "Dog name size must be between {min} and {max}")
    private String name;

//    @NotEmpty(message = "Owner name field can't be empty")
    @Size(min = 2, max = 50, message = "Owner name size must be between {min} and {max}")
    private String ownerName;

//    @NotEmpty(message = "Owner No field can't be empty")
    @Size(min = 2, max = 50, message = "Owner number must be between {min} and {max}")
    private String ownerNo;

    @Email(message = "Owner email can't be empty")
    private String ownerEmail;

//    @NotEmpty(message = "Address field can't be empty")
    @Size(min = 2, max = 50, message = "Address must be between {min} and {max}")
    private String address;

    private String image_path;

    private Character status;

    private String image;
}
