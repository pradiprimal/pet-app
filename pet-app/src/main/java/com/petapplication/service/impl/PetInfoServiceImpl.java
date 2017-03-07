package com.petapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petapplication.entity.PetInfo;
import com.petapplication.repository.PetInfoRepository;
import com.petapplication.service.PetInfoService;

@Service
@Transactional
public class PetInfoServiceImpl implements PetInfoService {

	private final PetInfoRepository petInfoRepository;

	@Autowired
	public PetInfoServiceImpl(PetInfoRepository infoRepository) {
		this.petInfoRepository = infoRepository;
	}

	public boolean savePetInfo(PetInfo petInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePetInfo(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
