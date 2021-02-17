package com.example.demo.runner.leetcode.array.fibonacci;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "fibonacci")
public class FibonacciRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Fibonacci fib = new Fibonacci();
        int i = fib.calc(6);
        Integer.toString(i);
    }

    class Fibonacci{
        int calc(int n){
            if (n<1){
                return 0;
            }else if (n==1){
                return 1;
            }else if (n ==2){
                return 1;
            }

            int p=1,pp=1;
            int value=0;
            for (int i=3;i<=n;i++){
                value = p+pp;
                pp=p;
                p=value;
            }
            return value;

        }
    }
}
