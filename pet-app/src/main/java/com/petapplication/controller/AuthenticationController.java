package com.petapplication.controller;

import com.petapplication.entity.UserLoginInfo;
import com.petapplication.exception.UnauthorizedExceptionHandler;
import com.petapplication.requestDTO.LoginRequestDTO;
import com.petapplication.resource.constant.WebApiConstant;
import com.petapplication.responseDTO.SingleValueResponse;
import com.petapplication.service.LoginService;
import com.petapplication.utility.JWTUtils;
import com.sun.xml.internal.messaging.saaj.client.p2p.HttpSOAPConnectionFactory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class AuthenticationController {

    private final LoginService loginService;

    private JWTUtils jWTGeneratorUtils;

    public AuthenticationController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void setjWTGeneratorUtils(JWTUtils jWTGeneratorUtils) {
        this.jWTGeneratorUtils = jWTGeneratorUtils;
    }

    @PostMapping(WebApiConstant.LOGIN_API)
    public ResponseEntity<SingleValueResponse> authenticate(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        System.out.println(loginRequestDTO.toString());
        UserLoginInfo userLoginInfo = loginService.findUserLoginInfoByUserNameAndPassword(loginRequestDTO.getUserName(), loginRequestDTO.getPassword());
        if (userLoginInfo == null) {
            throw new UnauthorizedExceptionHandler("Invalid user name or password.");
        }
        String token = jWTGeneratorUtils.generateJWT(userLoginInfo);
        System.out.println("token" + token);
        return new ResponseEntity<>(new SingleValueResponse(token), HttpStatus.OK);
    }

}
