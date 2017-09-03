package com.example.SecondKill.controller;

import com.example.SecondKill.entity.User;
import com.example.SecondKill.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/user")
    @ResponseBody
    User user(){
        return userRepository.findAll().iterator().next();
    }
}
