package com.petapplication.requestDTO;

import com.petapplication.utility.ModelBase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class PetInfoRequestDTO extends ModelBase{
	
	private Long id;

	private String name;

	private String ownerName;

	private String ownerNo;

	private String ownerEmail;

	private String address;

	private String image_path;
}
