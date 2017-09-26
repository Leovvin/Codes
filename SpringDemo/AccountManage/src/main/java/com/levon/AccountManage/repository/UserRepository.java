package com.levon.AccountManage.repository;

import com.levon.AccountManage.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByName(String name);
}
