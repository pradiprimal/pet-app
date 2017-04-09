package com.petapplication.controller;

import com.petapplication.entity.UserMenu;
import com.petapplication.resource.constant.WebApiConstant;
import com.petapplication.service.UserMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pradip
 */
@RestController
@RequestMapping(WebApiConstant.BASE_API)
public class UserMenuController {

    @Autowired
    private UserMenuService userMenuService;

    @GetMapping(WebApiConstant.MENU)
    public ResponseEntity<List<UserMenu>> getAllUserMenu() {
        return new ResponseEntity<>(userMenuService.findAllMenu(), HttpStatus.OK);
    }
}
