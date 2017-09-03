package com.example.SecondKill.controller;

import com.example.SecondKill.entity.Goods;
import com.example.SecondKill.entity.User;
import com.example.SecondKill.repository.GoodsRepository;
import com.example.SecondKill.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class GoodsController {

    @Autowired
    GoodsRepository goodRepository;
    @RequestMapping("/goods")
    @ResponseBody
    Goods goods(){
        return goodRepository.findAll().iterator().next();
    }
}
