package com.levon.AccountManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greeting {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",required = false,defaultValue = "levon")String name, Model model){
        model.addAttribute("name",name);
        return "greeting.html";
    }
}
