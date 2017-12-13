package com.levon.AccountManage.security.service;

import com.google.common.collect.Lists;
import com.levon.AccountManage.account.entity.Role;
import com.levon.AccountManage.account.entity.User;
import com.levon.AccountManage.account.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByName(username);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("");
        }
        List<String > roles= Lists.newArrayList();
        for (Role role:user.getRoles()){
            roles.add(role.getName());
        }
        org.springframework.security.core.userdetails.User.UserBuilder builder= org.springframework.security.core.userdetails.User.withUsername(username);
        builder.accountExpired(false)
            .accountLocked(false)
            .password(user.getPassword())
            .disabled(false)
            .roles(roles.toArray(new String[0]));
        return builder.build();
    }
}