package com.example.demo.mall.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Product {
    Long id;
    String description;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
