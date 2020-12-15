package com.example.react.biz;

import com.example.react.entity.Account;
import com.example.react.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    @Transactional
    public Mono<Account> findAccount(Integer id){
        return repository.findById(id);
    }

    @Transactional
    public Flux<Account> findAll(){
        return repository.findAll();
    }
    @Transactional
    public Mono<Integer> exchange(Integer sourceId,Integer targetId,int value){


        return repository.increaseAsset(sourceId,value);
    }
}
