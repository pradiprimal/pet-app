package com.petapplication.responseDTO;

import com.petapplication.utility.ModelBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetInfoResponseDTO extends ModelBase {

    private Long id;

    private String name;

    private String ownerName;

    private String ownerNo;

    private String ownerEmail;

    private String address;

    private String imagePath;

    private Character status;
}
