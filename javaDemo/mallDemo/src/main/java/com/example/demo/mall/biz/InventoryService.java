package com.example.demo.mall.biz;

import com.example.demo.mall.mapper.InventoryMapper;
import com.example.demo.mall.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public boolean decreaseStock(Long id,int value){
        return mapper.decreaseStockWithoutOverSell(id,value)==1;
    }

    @Transactional
    public boolean decreaseStockForUpdate(Long id,int value){
        Inventory inventory = mapper.findByIdForUpdate(id);
        if (inventory.getStock()-value<0){
            return false;
        }
        inventory.setStock(inventory.getStock()-value);
        return mapper.updateStockById(inventory)==1;
    }

    @Transactional
    public Inventory findById(Long id){
        return mapper.findById(id);
    }
}
