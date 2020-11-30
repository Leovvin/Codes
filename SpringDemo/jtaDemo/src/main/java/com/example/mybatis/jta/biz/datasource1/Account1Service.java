package com.example.mybatis.jta.biz.datasource1;

import com.example.mybatis.jta.mapper.datasource1.Account1Mapper;
import com.example.mybatis.jta.model.datasource1.Account1;
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
        Account1 account1 = mapper.findAccount(id);
        int asset = account1.getAsset()+income;
        account1.setAsset(asset);
        if (mapper.update(account1)==0){
            throw new RuntimeException("account have been changed while transaction running");
        }
        return true;
    }

    @Transactional
    public boolean decreaseAsset(int id,int income){
        Account1 account1 = mapper.findAccount(id);
        int asset = account1.getAsset()-income;
        if (asset<0){
            throw new RuntimeException("asset can not less than 0");
        }
        account1.setAsset(asset);
        if (mapper.update(account1)==0){
            throw new RuntimeException("account have been changed while transaction running");
        }
        return true;
    }
}
