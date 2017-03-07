/**
 * 
 */
/**
 * @author admin
 *
 */
package com.petapplication.service;

import com.petapplication.entity.PetInfo;

public interface PetInfoService{
	boolean savePetInfo(PetInfo petInfo);
	
	boolean deletePetInfo(long id);
	
}