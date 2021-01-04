package com.example.demo.mall.mapper;

import com.example.demo.mall.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    Order create(Order example);
}
