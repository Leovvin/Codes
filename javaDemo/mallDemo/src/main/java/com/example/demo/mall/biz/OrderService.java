package com.example.demo.mall.biz;

import com.example.demo.mall.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Transactional
    public Order createOrder(long userId,long productId,int amount){
        return null;
    }
}
