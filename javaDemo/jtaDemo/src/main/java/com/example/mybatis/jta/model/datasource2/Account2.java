package com.example.mybatis.jta.model.datasource2;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Account2 {
    Integer id;
    String name;
    Integer asset;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
