package com.petapplication.controller;

import com.petapplication.entity.PetInfo;
import com.petapplication.entity.converter.utility.PetInfoUtils;
import com.petapplication.exception.ContentNotFoundException;
import com.petapplication.exception.OperationFailedException;
import com.petapplication.requestDTO.PetInfoRequestDTO;
import com.petapplication.resource.constant.WebApiConstant;
import com.petapplication.responseDTO.PetInfoResponseDTO;
import com.petapplication.service.PetInfoService;
import java.util.List;
import javax.validation.Valid;

import com.petapplication.utility.OfflineFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping(WebApiConstant.BASE_API)
public class PetInfoController {

    private final PetInfoService petInfoService;

    @Autowired
    public PetInfoController(PetInfoService infoService) {
        this.petInfoService = infoService;
    }

    @PostMapping(WebApiConstant.SAVE_PET_INFO)
    public ResponseEntity<Void> savePetInfo(@RequestBody @Valid PetInfoRequestDTO petInfoRequestDTO) {
        petInfoService.savePetInfo(PetInfoUtils.convertIntoEntity(petInfoRequestDTO, petInfoService));
//        OfflineFile.writeFileToLocally(petInfoRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(WebApiConstant.GET_ALL_PET_INFO)
    public ResponseEntity<List<PetInfoResponseDTO>> getAllPetInfo() {
        List<PetInfo> petInfos = petInfoService.getPetInfos();
        if (petInfos.isEmpty()) {
            throw new ContentNotFoundException("Sorry! Content not found.");
        }
        return new ResponseEntity<>(PetInfoUtils.convertIntoPetInfoResponse(petInfos), HttpStatus.OK);
    }

    @DeleteMapping(WebApiConstant.DELETE_PET_INFO)
    public ResponseEntity<Void> deletePetInfo(@PathVariable Long id) {
        petInfoService.deletePetInfo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(WebApiConstant.UPDATE_PET_INFO)
    public ResponseEntity<Void> updatePetInfo(@RequestBody @Valid PetInfoRequestDTO petInfoRequestDTO) {
        PetInfo petInfo = petInfoService.findById(petInfoRequestDTO.getId());
        if (petInfo != null) {
            if (!petInfoService.savePetInfo(PetInfoUtils.convertIntoEntity(petInfoRequestDTO, petInfo))) {
                throw new OperationFailedException("Sorry! Content not found.");
            }
        } else {
            throw new ContentNotFoundException("Sorry! Content not found.");
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
