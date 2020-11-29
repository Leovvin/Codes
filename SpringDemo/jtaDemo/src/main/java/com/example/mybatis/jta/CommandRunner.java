package com.example.mybatis.jta;

import com.example.mybatis.jta.biz.bank1.Account1Service;
import com.example.mybatis.jta.biz.bank1.SequenceService;
import com.example.mybatis.jta.model.bank1.Account1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    Account1Service account1Service;
    @Autowired
    SequenceService sequenceService;

    @Override
    public void run(String... args) throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        for (int i=0;i<10;i++){
//            executorService.submit(()->{
//                for (int j=0;j<10000;j++){
//                    sequenceService.increase();
//                }
//            });
//        }
    }
}
