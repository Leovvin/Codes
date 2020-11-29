package com.example.mybatis.jta;

import com.example.mybatis.jta.biz.bank1.Account1Service;
import com.example.mybatis.jta.model.bank1.Account1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    Account1Service account1Service;

    @Override
    public void run(String... args) throws Exception {

        boolean b =account1Service.decreaseAsset(1,10);
        System.out.println("ss");
    }
}
