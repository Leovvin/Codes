package com.example.demo.mall.biz;

import com.example.demo.mall.mapper.InventoryMapper;
import com.example.demo.mall.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InventoryService {

    @Autowired
    InventoryMapper mapper;

    @Transactional
    public boolean increaseStock(Long id,int value){
        mapper.increaseStock(id,value);
        return true;
    }

    @Transactional
    public boolean increaseStockForUpdate(Long id,int value){
        Inventory inventory = mapper.findByIdForUpdate(id);
        inventory.setStock(inventory.getStock()+value);
        mapper.updateStockById(inventory);
        return true;
    }

    @Transactional
    public Inventory findById(Long id){
        return mapper.findById(id);
    }
}
