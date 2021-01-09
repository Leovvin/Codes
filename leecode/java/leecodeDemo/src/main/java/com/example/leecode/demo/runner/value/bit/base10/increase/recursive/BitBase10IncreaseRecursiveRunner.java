package com.example.leecode.demo.runner.value.bit.base10.increase.recursive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "bitBase10IncreaseRecursive")
public class BitBase10IncreaseRecursiveRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int n = 2;
        IncreasePrinterRecursive ip = new IncreasePrinterRecursive();
        ip.print(n);
        System.out.println("complete");
    }

    class IncreasePrinterRecursive{

        void print(int n){
            int[] value = new int[n];
            printRecursive(value,0);
        }

        void printRecursive(int[] value,Integer base){
            if (base == value.length){
                print(value);
                return;
            }
            for (int i=0;i<10;i++){
                value[base] = i;
                printRecursive(value,base+1);
            }
        }


        void print(int[] value){
            StringBuffer sb = new StringBuffer();
            boolean highZero = true;
            for (int i = 0;i<value.length;i++){
                if (highZero){
                    if( value[i]==0){
                        continue;
                    }else {
                        sb.append(value[i]);
                        highZero = false;
                    }
                }else {
                    sb.append(value[i]);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
