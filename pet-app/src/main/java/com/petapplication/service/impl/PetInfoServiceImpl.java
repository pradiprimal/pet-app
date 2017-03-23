package com.petapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petapplication.entity.PetInfo;
import com.petapplication.repository.PetInfoRepository;
import com.petapplication.service.PetInfoService;
import java.util.List;

@Service
public class PetInfoServiceImpl implements PetInfoService {

    private final PetInfoRepository petInfoRepository;

    @Autowired
    public PetInfoServiceImpl(PetInfoRepository infoRepository) {
        this.petInfoRepository = infoRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean savePetInfo(PetInfo petInfo) {
        return petInfoRepository.save(petInfo) != null;
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePetInfo(Long id) {
        petInfoRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetInfo> getPetInfos() {
        return petInfoRepository.getAllPetInfos();
    }

    @Override
    public boolean isEmailExist(String email) {
        return petInfoRepository.findByOwnerEmail(email) != null;
    }

    @Override
    public boolean isMobileNoExist(String mobileNo) {
        return petInfoRepository.findByOwnerNo(mobileNo) != null;
    }

    @Override
    public PetInfo findById(Long id) {
        return petInfoRepository.findOne(id);
    }

}
