package com.example.mybatis.jta.mapper.datasource2;

import com.example.mybatis.jta.model.datasource2.Account2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Account2Mapper {

    Account2 findAccount(int id);

    int create(Account2 account);

    int update(Account2 account1);

    int increase(int id,int income);

    int decrease(int id,int outcome);
}
