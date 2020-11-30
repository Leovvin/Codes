package com.example.mybatis.jta.biz.datasource1;

import com.example.mybatis.jta.mapper.datasource1.InventoryMapper;
import com.example.mybatis.jta.model.datasource1.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;

    @Transactional
    public int findNumberById(int id){
        return inventoryMapper.findNumberById(id);
    }

    @Transactional
    public boolean createInventory(Inventory inventory){
        return inventoryMapper.createInventory(inventory)==1;
    }

    @Transactional
    public boolean decreaseInventoryForUpdate(int id,int decrease){
        int number = inventoryMapper.findNumberByIdForUpdate(id);
        number = number-decrease;
        if (number<0){
            return false;
        }
        boolean b = inventoryMapper.updateInventory(id,number)==1;
        return b;
    }

    @Transactional
    public boolean decreaseInventory(int id,int decrease){
        boolean b = inventoryMapper.decreaseInventory(id,decrease)==1;
        return b;
    }
}
