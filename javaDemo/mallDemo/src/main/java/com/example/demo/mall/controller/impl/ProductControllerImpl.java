package com.example.demo.mall.controller.impl;

import com.example.demo.mall.controller.IProductController;
import com.example.demo.mall.dto.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("product")
public class ProductControllerImpl implements IProductController {
    @Override
    @PostMapping("book")
    public ResponseEntity<Object> book(@PathParam("productId") String productId,@PathParam("amount") Integer amount) {
        return ResponseEntity.success("hello");
    }
}
