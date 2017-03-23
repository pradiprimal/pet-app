/**
 * @author admin
 *
 */
package com.petapplication.service;

import com.petapplication.entity.PetInfo;
import java.util.List;

public interface PetInfoService {

    boolean savePetInfo(PetInfo petInfo);

    void deletePetInfo(Long id);

    List<PetInfo> getPetInfos();

    boolean isEmailExist(String email);

    boolean isMobileNoExist(String mobileNo);

    PetInfo findById(Long id);

}
