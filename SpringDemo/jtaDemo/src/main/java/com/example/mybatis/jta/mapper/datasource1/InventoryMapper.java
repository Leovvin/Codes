package com.example.mybatis.jta.mapper.datasource1;

import com.example.mybatis.jta.model.datasource1.Inventory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryMapper {

    int findNumberByIdForUpdate(int id);

    int findNumberById(int id);

    int updateInventory(int id,int inventoryNumber);

    int decreaseInventory(int id,int decrease);

    int createInventory(Inventory inventory);
}
