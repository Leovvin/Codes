package com.levon.AccountManage.repository.security;

import com.levon.AccountManage.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    @Query("select u.username as username,")
    List<Authority> findByUsername(String username);

}
