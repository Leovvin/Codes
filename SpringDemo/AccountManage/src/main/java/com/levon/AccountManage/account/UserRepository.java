package com.levon.AccountManage.account;

import com.levon.AccountManage.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
