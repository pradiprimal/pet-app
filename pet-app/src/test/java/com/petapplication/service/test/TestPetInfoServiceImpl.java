package com.petapplication.service.test;

import com.petapplication.entity.PetInfo;
import com.petapplication.service.PetInfoService;
import com.petapplication.service.impl.PetInfoServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author admin
 */
public class TestPetInfoServiceImpl {

    @InjectMocks
    private PetInfoService petInfoService;

    private final PetInfo petInfo = TestPetDataUtils.getPetInfo();

    private final List<PetInfo> petInfos = Arrays.asList(petInfo);

    @BeforeClass
    public void setUp() {
        petInfoService = Mockito.mock(PetInfoServiceImpl.class);
        when(petInfoService.savePetInfo(petInfo)).thenReturn(true);
        when(petInfoService.getPetInfos()).thenReturn(petInfos);
        when(petInfoService.isEmailExist("test@gmail.com")).thenReturn(true);
        when(petInfoService.findById(1l)).thenReturn(petInfo);
    }

    @Test
    public void testShouldSavePetInfo() {
        boolean isSave = petInfoService.savePetInfo(petInfo);
        assertTrue(isSave);

        isSave = petInfoService.savePetInfo(new PetInfo());
        assertFalse(isSave);

        verify(petInfoService, times(1)).savePetInfo(petInfo);//ENSURE IF savePetInfo METHOD OF PetInfoService CALLED ONLY ONCE BY PROVIDING CORRECT PARAMETER
    }

    @Test
    public void testShouldFetchPetInfos() {
        List<PetInfo> infos = petInfoService.getPetInfos();
        assertEquals(petInfos, infos);

        verify(petInfoService, times(1)).getPetInfos();
    }

    @Test
    public void testShouldCheckIsOwnerEmailAdddressExist() {
        boolean isEmailExist = petInfoService.isEmailExist("test@gmail.com");
        assertTrue(isEmailExist);
        verify(petInfoService, times(1)).isEmailExist("test@gmail.com");
    }

    @Test
    public void testShouldFindPetInfoById() {
        PetInfo info = petInfoService.findById(1l);
        assertEquals(petInfo, info);
        verify(petInfoService, times(1)).findById(1l);
    }
}
