package com.petapplication.repository;

import com.petapplication.entity.UserMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pradip
 */
public interface UserMenuRepository extends JpaRepository<UserMenu, Long>{
    
}
