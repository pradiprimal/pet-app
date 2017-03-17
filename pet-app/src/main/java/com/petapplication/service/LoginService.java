package com.petapplication.service;

import com.petapplication.entity.UserLoginInfo;

/**
 *
 * @author admin
 */
public interface LoginService {
       UserLoginInfo findUserLoginInfoByUserNameAndPassword(String userName, String password);
}
