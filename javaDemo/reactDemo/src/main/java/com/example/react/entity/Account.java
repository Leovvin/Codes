package com.example.react.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity(name = "account")
public class Account {
    @Id
    Integer id;
    String name;
    Integer asset;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
