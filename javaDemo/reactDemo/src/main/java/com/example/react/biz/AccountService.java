package com.example.react.biz;

import com.example.react.entity.Account;
import com.example.react.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

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
    public Mono<Boolean> exchange(Integer sourceId,Integer targetId,int value){
        Mono<Account> sourceMono = decreaseAccount(sourceId,value);
        Mono<Account> targetMono = increaseAccount(targetId,value);

        Mono<Tuple2<Account,Account>> accountPub =targetMono.zipWith(sourceMono);

        return Mono.usingWhen(accountPub,tuple->Mono.just(true),tuple->Mono.just(tuple));
    }

    @Transactional
    public Mono<Account> decreaseAccount(Integer accountId,int value){
        Mono<Account> accountMono = repository.findById(accountId);

        return Mono.usingWhen(accountMono,account->{
            if (account.getAsset()-value>0){
                account.setAsset(account.getAsset()-value);
                return repository.save(account);
            }else {
                return Mono.error(new RuntimeException("asset can not be negative"));
            }

        },account->Mono.just(account));

    }

    @Transactional
    public Mono<Account> increaseAccount(Integer accountId,int value){
        Mono<Account> accountMono = repository.findById(accountId);

        return Mono.usingWhen(accountMono,account->{
            account.setAsset(account.getAsset()+value);
            return repository.save(account);
        },account->Mono.just(account));
    }

    @Transactional
    public Mono<Account> save(Account account){
        return repository.save(account);
    }
}
