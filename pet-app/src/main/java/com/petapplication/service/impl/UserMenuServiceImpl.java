package com.petapplication.service.impl;

import com.petapplication.entity.UserMenu;
import com.petapplication.repository.UserMenuRepository;
import com.petapplication.service.UserMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pradip
 */
@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Autowired
    private UserMenuRepository userMenuRepository;

    @Override
    public List<UserMenu> findAllMenu() {
        return userMenuRepository.findAll();
    }

}
