package com.petapplication.service.test;

import com.petapplication.entity.PetInfo;

/**
 *
 * @author admin
 */
public class TestPetDataUtils {

    public static PetInfo getPetInfo() {
        PetInfo petInfo = new PetInfo();
        petInfo.setAddress("kathmandu");
        petInfo.setId(1l);
        petInfo.setImagePath("image");
        petInfo.setName("Puppy");
        petInfo.setOwnerEmail("test@gmai.com");
        petInfo.setOwnerName("Hari Thapa");
        petInfo.setOwnerNo("9849174639");
        petInfo.setStatus('Y');
        return petInfo;
    }

}
