package com.example.RushingBuy.controller;

import com.example.RushingBuy.bo.Book;
import com.example.RushingBuy.entity.Goods;
import com.example.RushingBuy.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    Goods add(@RequestBody Book book) {
        Long goodsid=book.getGoodid();
        Goods goods=goodsRepository.findOne(goodsid);
        int num=goods.getNum()-1;
        goods.setNum(num);
        return goodsRepository.saveAndFlush(goods);
    }
}
