/**
 * @author admin
 *
 */
package com.petapplication.service;

import com.petapplication.entity.PetInfo;
import java.util.List;

public interface PetInfoService {

    boolean savePetInfo(PetInfo petInfo);

    void deletePetInfo(long id);

    public List<PetInfo> getPetInfos();

}
