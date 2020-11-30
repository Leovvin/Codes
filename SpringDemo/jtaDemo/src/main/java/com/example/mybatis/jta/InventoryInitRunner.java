package com.example.mybatis.jta;

import com.example.mybatis.jta.biz.datasource1.InventoryService;
import com.example.mybatis.jta.model.datasource1.Inventory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@Component
@ConditionalOnProperty(value = "jta.demo",havingValue = "inventoryInit")
public class InventoryInitRunner implements CommandLineRunner {


    @Autowired
    InventoryService inventoryService;

    @Override
    public void run(String... args) throws Exception {

        for (int i=0;i<10000000;i++){
            Inventory inventory = new Inventory();
            inventory.setName(generateName());
            inventory.setNumber(generateNumber());
            if (!inventoryService.createInventory(inventory)){
                System.out.println("init failed");
            }
        }

        System.out.println("complete");
    }

    private String generateName(){
        int size = 1 + (int)(Math.random()*10);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<size;i++){
            char c = (char)(97+(int)(Math.random()*26));
            sb.append(c);
        }
        return sb.toString();
    }

    private int generateNumber(){
        return (int)(10+Math.random()*1000);
    }

}
