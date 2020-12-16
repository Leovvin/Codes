package com.example.react.repository;

import com.example.react.entity.Account;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends R2dbcRepository<Account,Integer> {

    @Query("update Account set asset=asset+?2 where id = ?1")
    Mono<Integer> increaseAsset(Integer id,int value);

    @Query("update Account set asset=asset-?2 where id = ?1 and asset-?2>0")
    @Modifying
    Mono<Integer> decreaseAsset(Integer id,int value);
}
