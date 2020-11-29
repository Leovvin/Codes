package com.example.mybatis.jta.biz.bank1;

import com.example.mybatis.jta.mapper.bank1.Account1Mapper;
import com.example.mybatis.jta.model.bank1.Account1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Account1Service {
    @Autowired
    Account1Mapper mapper;

    @Transactional
    public Account1 create(Account1 account1){
        mapper.create(account1);
        return account1;
    }

    @Transactional
    public Account1 findById(int id){
        return mapper.findAccount(id);
    }

    @Transactional
    public boolean increaseAsset(int id,int income){
        Account1 account1 = mapper.findAccountForUpdate(id);
        int asset = account1.getAsset()+income;
        account1.setAsset(asset);
        return mapper.update(account1)==1;
    }

    @Transactional
    public boolean decreaseAsset(int id,int income){
        Account1 account1 = mapper.findAccountForUpdate(id);
        int asset = account1.getAsset()-income;
        if (asset<0){
            throw new RuntimeException("asset can not less than 0");
        }
        account1.setAsset(asset);
        return mapper.update(account1)==1;
    }
}
