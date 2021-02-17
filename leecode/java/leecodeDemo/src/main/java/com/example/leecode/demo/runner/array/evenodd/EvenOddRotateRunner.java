package com.example.leecode.demo.runner.array.evenodd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@ConditionalOnProperty(name = "runner",havingValue = "evenOdd")
public class EvenOddRotateRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    class Rotator{
        public void rotate(int[] array){

        }
    }
}
