package com.example.leecode.demo.runner.value.prime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 题目：
 * 计算10000000以内的所有素数
 */

@Component
@ConditionalOnProperty(name = "runner",havingValue = "prime")
public class PrimeRunner implements CommandLineRunner {
    static final int MAX_VALUE=1000000;
    @Override
    public void run(String... args) throws Exception {
        boolean[] isComposite = new boolean[MAX_VALUE+1];

        for (int i=2;i<(MAX_VALUE/2)+1;i++){
            boolean isPrime = !isComposite[i];
            if (isPrime){
                int k = 2;
                while (i*k<MAX_VALUE){
                    isComposite[i*k]=true;
                    k++;
                }
            }
        }

        int num = 0;
        for (int i=2;i<MAX_VALUE+1;i++){
            if (!isComposite[i]){
                num++;
            }
        }
        System.out.println(num);
    }
}
