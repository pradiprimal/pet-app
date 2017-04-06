package com.petapplication.controller;

import com.petapplication.resource.constant.WebApiConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pradip on 4/3/17.
 */
@RestController
@RequestMapping(WebApiConstant.BASE_API)
public class TestConnectionApiController {

    @RequestMapping(WebApiConstant.TEST_API)
    public String testConnection(){
        return "Server Started Successfully !!";
    }
}
