package com.levon.AccountManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public Principal login(Principal user){
        return user;
    }
}
