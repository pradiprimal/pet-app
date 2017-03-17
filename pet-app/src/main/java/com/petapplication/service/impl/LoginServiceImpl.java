package com.petapplication.service.impl;

import com.petapplication.entity.UserLoginInfo;
import com.petapplication.repository.UserLoginInfoRepository;
import com.petapplication.service.LoginService;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserLoginInfoRepository userLoginInfoRepository;

    public LoginServiceImpl(UserLoginInfoRepository userLoginInfoRepository) {
        this.userLoginInfoRepository = userLoginInfoRepository;
    }

    @Override
    public UserLoginInfo findUserLoginInfoByUserNameAndPassword(String userName, String password) {
        return userLoginInfoRepository.findByEmailAndPassword(userName, password);
    }

}
