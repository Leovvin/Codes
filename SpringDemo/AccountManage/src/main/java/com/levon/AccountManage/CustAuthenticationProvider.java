package com.levon.AccountManage;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
//        CustUserDetails userDetials = (CustUserDetails) userService.loadUserByUsername(username);
//        Collection<? extends GrantedAuthority> authorities = userDetials.getAuthorities();
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
