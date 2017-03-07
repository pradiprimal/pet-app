package com.petapplication.controller;

import com.petapplication.entity.converter.utility.PetInfoUtils;
import com.petapplication.requestDTO.PetInfoRequestDTO;
import com.petapplication.resource.constant.WebApiConstant;
import com.petapplication.service.PetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<Void> savePetInfo(@RequestBody PetInfoRequestDTO petInfoRequestDTO) {
        System.out.println("Called!!");
        petInfoService.savePetInfo(PetInfoUtils.convertIntoEntity(petInfoRequestDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(WebApiConstant.GET_ALL_PET_INFO)
    @GetMapping
    public ResponseEntity<Void> getAllPetInfo() {
        System.out.println("Called!!");
//        petInfoService.savePetInfo(PetInfoUtils.convertIntoEntity(petInfoRequestDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
