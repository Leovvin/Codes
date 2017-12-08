package com.levon.AccountManage.security.repository;

import com.levon.AccountManage.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
