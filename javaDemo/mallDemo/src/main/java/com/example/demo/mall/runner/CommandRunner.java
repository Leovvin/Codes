package com.example.demo.mall.runner;

import com.example.demo.mall.biz.InventoryService;
import com.example.demo.mall.mapper.InventoryMapper;
import com.example.demo.mall.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    InventoryService inventoryService;
    @Value("${spring.datasource.dbcp2.maxTotal}")
    int threadNum;

    @Override
    public void run(String... args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i=0;i<threadNum;i++){
            executorService.submit(new Updater());
        }
        new Thread(new Monitor()).start();
    }


    class Updater implements Runnable{
        @Override
        public void run() {
            while (true){
                inventoryService.increaseStock(1l,1);
            }
        }
    }

    class Monitor implements Runnable{
        int lastStock=0;
        @Override
        public void run() {
            while (true){
                Inventory inventory = inventoryService.findById(1l);
                int stock = inventory.getStock();
                System.out.println("stock increased:"+(stock-lastStock));
                lastStock = stock;
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
