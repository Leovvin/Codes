package com.example.mybatis.jta.mapper.bank1;

import com.example.mybatis.jta.model.bank1.Account1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Account1Mapper {

    Account1 findAccount(int id);

    Account1 findAccountForUpdate(int id);

    int create(Account1 account);

    int update(Account1 account1);
}
