package com.petapplication.entity.converter.utility;

import com.petapplication.entity.PetInfo;
import com.petapplication.requestDTO.PetInfoRequestDTO;

/**
 *
 * @author admin
 */
public class PetInfoUtils {

    public static PetInfo convertIntoEntity(PetInfoRequestDTO petInfoRequestDTO) {
        PetInfo petInfo = new PetInfo();
        petInfo.setAddress(petInfoRequestDTO.getAddress());
        petInfo.setName(petInfoRequestDTO.getName());
        petInfo.setOwnerEmail(petInfoRequestDTO.getOwnerEmail());
        petInfo.setOwnerName(petInfoRequestDTO.getOwnerName());
        petInfo.setOwnerNo(petInfoRequestDTO.getOwnerNo());
        petInfo.setImagePath("test");
        return petInfo;
    }

}
