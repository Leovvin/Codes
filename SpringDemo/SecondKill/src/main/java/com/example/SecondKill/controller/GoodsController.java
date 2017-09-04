package com.example.SecondKill.controller;

import com.example.SecondKill.entity.Goods;
import com.example.SecondKill.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsRepository goodsRepository;

    @GetMapping
    @ResponseBody
    Goods get(@RequestParam(value="id", defaultValue="1") long id){
        return goodsRepository.findOne(id);
    }
    @GetMapping("/all")
    @ResponseBody
    Iterable<Goods> getAll(){
        return goodsRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    Goods put(@RequestParam(value="id", defaultValue="1") long id,Goods goods){
        System.out.println(Thread.currentThread().getId());
        return goodsRepository.findOne(id);
    }

}
