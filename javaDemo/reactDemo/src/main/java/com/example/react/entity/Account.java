package com.example.react.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Account {
    @Id
    Integer id;
    String name;
    Integer asset;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
