package com.example.mybatis.jta.biz;

import com.example.mybatis.jta.mapper.datasource1.Account1Mapper;
import com.example.mybatis.jta.mapper.datasource2.Account2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExchangeService {
    @Autowired
    Account1Mapper account1Mapper;
    @Autowired
    Account2Mapper account2Mapper;


    @Transactional
    public boolean exchange(int fromId,int toId,int amount){
        int affectRow = account1Mapper.increase(fromId,amount);
        if (affectRow ==0){
            throw new RuntimeException("account1 not found");
        }

        affectRow = account2Mapper.decrease(toId,amount);
        if (affectRow == 0){
            throw new RuntimeException("decrease account2 failed");
        }
        return true;
    }

}
