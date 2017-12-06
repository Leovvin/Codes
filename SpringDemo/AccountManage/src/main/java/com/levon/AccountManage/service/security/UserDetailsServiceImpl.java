package com.levon.AccountManage.service.security;

import com.google.common.collect.Lists;
import com.levon.AccountManage.entity.security.Role;
import com.levon.AccountManage.entity.security.User;
import com.levon.AccountManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByName(username);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("");
        }
        List<String > roles= Lists.newArrayList();
        for (Role role:user.getRoles()){
            roles.add(role.getDescription());
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
