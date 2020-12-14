package com.example.react;

import com.example.react.entity.Account;
import com.example.react.repository.AccountRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    AccountRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Flux<Account> accountFlux = repository.findAll();
        accountFlux.subscribe(ac->{
            ac.getName();
        });
    }
}
