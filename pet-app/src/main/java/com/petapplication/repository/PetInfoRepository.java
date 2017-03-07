package com.petapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petapplication.entity.PetInfo;

public interface PetInfoRepository extends JpaRepository<PetInfo, Long>{

}
