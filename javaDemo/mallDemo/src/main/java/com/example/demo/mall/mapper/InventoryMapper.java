package com.example.demo.mall.mapper;

import com.example.demo.mall.model.Inventory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryMapper {
    Inventory findById(Long id);
    int increaseStock(Long id,int value);
    int decreaseStockWithoutOverSell(Long id,int value);
    Inventory findByIdForUpdate(Long id);
    int updateStockById(Inventory inventory);
}
