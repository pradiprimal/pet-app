package com.petapplication.requestDTO;

import com.petapplication.utility.ModelBase;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class PetInfoRequestDTO extends ModelBase {

    private Long id;

    @NotEmpty(message = "Dog name field can't be empty")
    private String name;

    @NotEmpty(message = "Owner name field can't be empty")
    private String ownerName;

    @NotEmpty(message = "Owner No field can't be empty")
    private String ownerNo;

    @Email(message = "Owner email can't be empty")
    private String ownerEmail;

    @NotEmpty(message = "Address field can't be empty")
    private String address;

    private String image_path;

    private Character status;
}
