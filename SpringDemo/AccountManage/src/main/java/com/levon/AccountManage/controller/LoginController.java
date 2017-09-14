package com.levon.AccountManage.controller;

import com.levon.AccountManage.bo.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping("/rest/login")
    @ResponseBody
    String login(@RequestBody String s){
        return "ss";
    }
}
