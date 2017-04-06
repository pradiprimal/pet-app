package com.petapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petapplication.entity.PetInfo;
import com.petapplication.repository.custom.PetInfoRepositoryCustom;

public interface PetInfoRepository extends JpaRepository<PetInfo, Long>, PetInfoRepositoryCustom {

    PetInfo findByOwnerEmail(String email);

    PetInfo findByOwnerNo(String no);
}
