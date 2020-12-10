package com.example.mybatis.jta.model.datasource1;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Account1 {
    Integer id;
    String name;
    Integer asset;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
