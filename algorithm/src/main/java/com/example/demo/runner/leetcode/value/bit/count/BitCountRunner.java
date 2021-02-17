package com.example.demo.runner.leetcode.value.bit.count;

import com.google.common.collect.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "bitCount")
public class BitCountRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int value = 9;

        List<Integer> result = Lists.newArrayList();
        int flag=1;
        while (flag!=0){
            if ((value&flag) == flag){
                result.add(1);
            }else {
                result.add(0);
            }
            flag = flag<<1;
        }
        result.size();
    }
}
