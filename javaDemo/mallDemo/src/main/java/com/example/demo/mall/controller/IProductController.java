package com.example.demo.mall.controller;

import com.example.demo.mall.dto.ResponseEntity;

public interface IProductController {

    ResponseEntity<String> book(String productId,Integer amount);
}
