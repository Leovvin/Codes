package com.example.leecode.demo.runner.array.rotate.singledouble;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 题目：
 * 输入一组整数，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 */
@Component
@ConditionalOnProperty(name = "runner",havingValue = "singleDoubleRotate")
public class SingleDoubleRotateRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int[] array = randomArray(10);
        printArray(array);
        rotate(array);
        printArray(array);

    }

    private void rotate(int[] array){
        if (array == null || array.length==0){
            return;
        }
        int i=0,j = array.length-1;
        while (i<j){
            while (i<j && (array[i]%2)!=0){
                i++;
            }
            while (i<j && (array[j]%2)==0){
                j--;
            }
            if (i<j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
    }

    private void printArray(int[] array){
        if (array == null || array.length==0){
            return;
        }
        String s = Arrays.stream(array).boxed().map(i->Integer.toString(i)).collect(Collectors.joining(" ")).toString();
        System.out.println(s);
    }

    private int[] randomArray(int size){
        if (size == 0){
            return null;
        }

        int[] array = new int[size];
        for (int i=0;i<size;i++){
            array[i] = (int)(Math.random()*100);
        }
        return array;
    }
}
