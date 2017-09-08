package com.example.RushingBuy.controller;

import com.example.RushingBuy.entity.Goods;
import com.example.RushingBuy.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
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
        return goodsRepository.save(goods);
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    Goods add(@RequestBody Goods goods) {
        return goodsRepository.save(goods);
    }
}
