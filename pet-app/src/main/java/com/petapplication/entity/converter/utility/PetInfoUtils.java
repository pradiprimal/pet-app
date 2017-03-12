package com.petapplication.entity.converter.utility;

import com.petapplication.entity.PetInfo;
import com.petapplication.requestDTO.PetInfoRequestDTO;
import com.petapplication.responseDTO.PetInfoResponseDTO;
import com.petapplication.utility.FileProcessorUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PetInfoUtils {
    
    public static PetInfo convertIntoEntity(PetInfoRequestDTO petInfoRequestDTO) {
        PetInfo petInfo = new PetInfo();
        petInfo.setAddress(petInfoRequestDTO.getAddress());
        petInfo.setId(petInfoRequestDTO.getId());
        petInfo.setName(petInfoRequestDTO.getName());
        petInfo.setOwnerEmail(petInfoRequestDTO.getOwnerEmail());
        petInfo.setOwnerName(petInfoRequestDTO.getOwnerName());
        petInfo.setOwnerNo(petInfoRequestDTO.getOwnerNo());
        if (petInfoRequestDTO.getImage() != null && !petInfoRequestDTO.getImage().isEmpty()) {
            petInfo.setImagePath(FileProcessorUtils.writeImageAndReturnPath(petInfoRequestDTO.getImage()));
        }
        petInfo.setStatus('Y');
        petInfo.setId(petInfoRequestDTO.getId());
        return petInfo;
    }
    
    public static List<PetInfoResponseDTO> convertIntoPetInfoResponse(List<PetInfo> petInfos) {
        
        List<PetInfoResponseDTO> petInfoResponseDTOs = new ArrayList<>();
        petInfos.forEach(petInfo -> {
            petInfoResponseDTOs.add(convertIntoPetInfo(petInfo));
        });
        return petInfoResponseDTOs;
    }
    
    public static PetInfoResponseDTO convertIntoPetInfo(PetInfo petInfo) {
        PetInfoResponseDTO petInfoResponseDTO = new PetInfoResponseDTO();
        petInfoResponseDTO.setId(petInfo.getId());
        petInfoResponseDTO.setAddress(petInfo.getAddress());
        petInfoResponseDTO.setName(petInfo.getName());
        petInfoResponseDTO.setOwnerEmail(petInfo.getOwnerEmail());
        petInfoResponseDTO.setOwnerNo(petInfo.getOwnerNo());
        petInfoResponseDTO.setImagePath(FileProcessorUtils.decodeImageIntoString(petInfo.getImagePath()));
        petInfoResponseDTO.setOwnerName(petInfo.getOwnerName());
        petInfoResponseDTO.setStatus(petInfo.getStatus());
        return petInfoResponseDTO;
    }
    
}
