package com.example.mybatis.jta;

import com.example.mybatis.jta.biz.ExchangeService;
import com.example.mybatis.jta.mapper.datasource1.Account1Mapper;
import com.example.mybatis.jta.mapper.datasource2.Account2Mapper;
import com.example.mybatis.jta.model.datasource1.Account1;
import com.example.mybatis.jta.model.datasource2.Account2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    ExchangeService exchangeService;
    @Override
    public void run(String... args) throws Exception {
        boolean b = exchangeService.exchange(1,1,2);
        if (b==true){
            System.out.println("exchange success");
        }
    }
}
