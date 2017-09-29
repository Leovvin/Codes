package com.levon.AccountManage.repository;

import com.levon.AccountManage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
