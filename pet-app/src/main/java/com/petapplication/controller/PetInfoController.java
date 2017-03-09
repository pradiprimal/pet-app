package com.petapplication.controller;

import com.petapplication.entity.PetInfo;
import com.petapplication.entity.converter.utility.PetInfoUtils;
import com.petapplication.requestDTO.PetInfoRequestDTO;
import com.petapplication.resource.constant.WebApiConstant;
import com.petapplication.responseDTO.PetInfoResponseDTO;
import com.petapplication.service.PetInfoService;
import java.util.Base64;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping(WebApiConstant.SAVE_PET_INFO)
    @PostMapping
    public ResponseEntity<Void> savePetInfo(@RequestBody @Valid PetInfoRequestDTO petInfoRequestDTO) {
        System.out.println("Called!!");
        petInfoService.savePetInfo(PetInfoUtils.convertIntoEntity(petInfoRequestDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @CrossOrigin(origins = "http://localhost:8084")
    @GetMapping(WebApiConstant.GET_ALL_PET_INFO)
    public ResponseEntity<List<PetInfoResponseDTO>> getAllPetInfo() {
        List<PetInfo> petInfos = petInfoService.getPetInfos();
        return new ResponseEntity<>(PetInfoUtils.convertIntoPetInfoResponse(petInfos), HttpStatus.OK);
    }

    @PostMapping(WebApiConstant.DELETE_PET_INFO)
    public ResponseEntity<Void> deletePetInfo(@PathVariable Long id) {
        petInfoService.deletePetInfo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
