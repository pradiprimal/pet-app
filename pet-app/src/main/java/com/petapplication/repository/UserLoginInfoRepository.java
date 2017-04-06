package com.petapplication.repository;

import com.petapplication.entity.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author admin
 */
public interface UserLoginInfoRepository extends JpaRepository<UserLoginInfo, Long> {

    UserLoginInfo findByEmailAndPassword(String email, String password);
}
