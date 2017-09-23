package com.levon.AccountManage.controller;

import com.levon.AccountManage.entity.User;
import com.levon.AccountManage.form.Login;
import com.levon.AccountManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/rest/login")
    @ResponseBody
    String login(@RequestBody Login login){
        String username=login.getUsername();
        String password=login.getPassword();
        User user=userRepository.findByName(username);
        String token=null;
        if (Objects.nonNull(user)&&password.equals(user.getPassword())){
            token= UUID.randomUUID().toString();
        }

//        return "{\"token\":\""+token+"\"}";
        return token;
    }
}
