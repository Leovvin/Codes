package com.levon.AccountManage.service;

import com.levon.AccountManage.entity.Users;
import com.levon.AccountManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=userRepository.findByName(username);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("");
        }
        User.UserBuilder builder= User.withUsername(username);
        builder.accountExpired(true)
            .accountLocked(true)
            .password(user.getPassword())
            .roles("ADMIN");
        return builder.build();
    }
}
