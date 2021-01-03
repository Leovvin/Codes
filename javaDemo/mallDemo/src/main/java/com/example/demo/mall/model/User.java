package com.example.demo.mall.model;

import com.example.demo.mall.type.Sex;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    Long id;
    String name;
    Sex sex;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
