package com.example.react;

import com.example.react.biz.AccountService;
import com.example.react.entity.Account;
import com.example.react.repository.AccountRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class CommandRunner implements CommandLineRunner {
    @Autowired
    AccountService accountService;
    @Override
    public void run(String... args) throws Exception {
        accountService.exchange(1,2,10).subscribe(b->{
            System.out.println(b);
        });

        accountService.findAll().subscribe(account -> {
            System.out.println(account.getAsset());
        });
    }
}
