package com.levon.AccountManage.service;

import com.levon.AccountManage.entity.Role;
import com.levon.AccountManage.entity.User;
import com.levon.AccountManage.entity.UserRole;
import com.levon.AccountManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByName(username);
        Set<Role> roles=user.getRoles();
        for (Role role:roles){
            String desc=role.getDesc();
        }
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("");
        }
        org.springframework.security.core.userdetails.User.UserBuilder builder= org.springframework.security.core.userdetails.User.withUsername(username);
        builder.accountExpired(true)
            .accountLocked(true)
            .password(user.getPassword())
            .roles("ADMIN");
        return builder.build();
    }
}
