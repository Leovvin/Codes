package com.levon.AccountManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails userDetials = (UserDetails) userDetailsService.loadUserByUsername(username);
        if (!password.equals(userDetials.getPassword())){
            throw new AuthenticationExceptionDefault("");
        }
        Collection<? extends GrantedAuthority> authorities = userDetials.getAuthorities();
        Authentication authentication1=new UsernamePasswordAuthenticationToken(username,password,authorities);
        return authentication1;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
