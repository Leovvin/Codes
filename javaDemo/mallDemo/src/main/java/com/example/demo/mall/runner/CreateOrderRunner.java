package com.example.demo.mall.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "createOrder")
public class CreateOrderRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
