package com.levon.AccountManage;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationExceptionDefault extends AuthenticationException {
    public AuthenticationExceptionDefault(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationExceptionDefault(String msg) {
        super(msg);
    }
}
