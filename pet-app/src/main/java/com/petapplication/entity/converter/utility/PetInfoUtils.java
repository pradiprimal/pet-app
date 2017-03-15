package com.petapplication.entity.converter.utility;

import com.petapplication.entity.PetInfo;
import com.petapplication.exception.ContentConflictException;
import com.petapplication.requestDTO.PetInfoRequestDTO;
import com.petapplication.responseDTO.PetInfoResponseDTO;
import com.petapplication.service.PetInfoService;
import com.petapplication.utility.FileProcessorUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PetInfoUtils {

    public static PetInfo convertIntoEntity(PetInfoRequestDTO petInfoRequestDTO, PetInfoService petInfoService) {
        PetInfo petInfo = new PetInfo();
        petInfo.setAddress(petInfoRequestDTO.getAddress());
        petInfo.setId(petInfoRequestDTO.getId());
        petInfo.setName(petInfoRequestDTO.getName());
        if (petInfoService.isEmailExist(petInfoRequestDTO.getOwnerEmail())) {
            throw new ContentConflictException("Sorry! email address '" + petInfoRequestDTO.getOwnerEmail() + "' already exist.");
        }
        petInfo.setOwnerEmail(petInfoRequestDTO.getOwnerEmail());
        petInfo.setOwnerName(petInfoRequestDTO.getOwnerName());
        if (petInfoService.isMobileNoExist(petInfoRequestDTO.getOwnerNo())) {
            throw new ContentConflictException("Sorry! mobile no '" + petInfoRequestDTO.getOwnerNo() + "' already exist.");
        }
        petInfo.setOwnerNo(petInfoRequestDTO.getOwnerNo());
        if (petInfoRequestDTO.getImage() != null && !petInfoRequestDTO.getImage().isEmpty()) {
            petInfo.setImagePath(FileProcessorUtils.writeImageAndReturnPath(petInfoRequestDTO.getImage()));
        }
        petInfo.setStatus('Y');
        return petInfo;
    }

    public static PetInfo convertIntoEntity(PetInfoRequestDTO petInfoRequestDTO, PetInfo petInfo) {
        petInfo.setAddress(petInfoRequestDTO.getAddress());
        petInfo.setId(petInfoRequestDTO.getId());
        petInfo.setName(petInfoRequestDTO.getName());
        petInfo.setOwnerEmail(petInfoRequestDTO.getOwnerEmail());
        petInfo.setOwnerName(petInfoRequestDTO.getOwnerName());
        petInfo.setOwnerNo(petInfoRequestDTO.getOwnerNo());
        petInfo.setStatus('Y');
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
