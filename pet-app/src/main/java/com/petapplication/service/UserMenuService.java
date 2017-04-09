package com.petapplication.service;

import com.petapplication.entity.UserMenu;
import java.util.List;

/**
 *
 * @author pradip
 */
public interface UserMenuService {
 
    List<UserMenu> findAllMenu();
}
