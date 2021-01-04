package com.example.leecode.demo.runner.value.power;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "valuePower")
public class ValuePowerRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    class Algorithm{
        double calc(double base,int exponent){

            return 0.0;
        }
    }
}
