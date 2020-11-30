package com.example.mybatis.jta;

import com.example.mybatis.jta.biz.datasource1.InventoryService;
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
@ConditionalOnProperty(value = "jta.demo",havingValue = "inventory")
public class InventoryRunner implements CommandLineRunner {

    public static final int POOL_SIZE=10;

    @Autowired
    InventoryService inventoryService;

    @Override
    public void run(String... args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        submitJob(executorService);
        submitMonitor(executorService);
    }

    private void submitMonitor(ExecutorService executorService){
        executorService.submit(()->{
            while (true){

                int diff = bean.sucNumberPerSec();
                int totalSuc = bean.getSucNum();
                System.out.println("last success number:"+diff+", total success:"+totalSuc);

                Thread.sleep(1000);
            }
        });
    }

    private void submitJob(ExecutorService executorService){
        for (int i=0;i<POOL_SIZE;i++){
            executorService.submit(()->{
                boolean b = true;
                while (b){
                    b=inventoryService.decreaseInventory(1,1);
                    if (b){
                        bean.increaseSuc();
                    }
                }
            });
        }
    }


    Bean bean = new Bean();

    @Getter
    @Setter
    class Bean{
        int lastSucNum;
        int sucNum;
        int lastFailNum;
        int failNum;
        ReentrantLock reentrantLock = new ReentrantLock();

        synchronized void increaseSuc(){
            try {
                reentrantLock.lock();
                sucNum++;
            }finally {
                reentrantLock.unlock();
            }

        }

        synchronized int sucNumberPerSec(){
            int diff=0;
            try {
                reentrantLock.lock();
                diff = sucNum - lastFailNum;
                lastFailNum = sucNum;
            }finally {
                reentrantLock.unlock();
            }

            return diff;
        }
    }
}
