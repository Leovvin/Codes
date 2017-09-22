package com.levon.AccountManage.repository;

import com.levon.AccountManage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
