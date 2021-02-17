package com.example.demo.runner.leetcode.array.rotate.search;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "runner",havingValue = "rotateArray")
public class RotateArraySearchCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int[] array = {8,9,1,2,3,4,5,6,7};
        Algorithm algorithm = new Algorithm();
        int i = algorithm.search(array,1);
        Integer.toString(i);
    }

    class Algorithm{
        int search(int[] array,int target){
            int rotateIndex = calcRotateIndex(array);
            int lResult = binarySearch(array,0,rotateIndex,target);
            int rResult = binarySearch(array,rotateIndex,array.length,target);
            return lResult!=-1?lResult:rResult!=-1?rResult:-1;

        }

        int binarySearch(int[] array,int begin ,int end,int target){
            int l=begin,r=end;

            while (l<=r-2){
                int m = (l+r)/2;
                if (array[m] == target){
                    return m;
                }else if (array[m]<target){
                    l = m;
                }else {
                    r = m;
                }
            }
            if ((l == r-1)&&array[l]==target){
                return l;
            }
            return -1;
        }

        int calcRotateIndex(int[] array){
            if (array==null){
                return -1;
            }
            int l = 0,r=array.length-1;
            while (l<r){
                int m = (l+r)/2;
                if ((l+1<array.length)&&(array[l]>array[l+1])){
                    return l+1;
                }else if (array[l]<array[m]){
                    l = m;
                }else {
                    r = m;
                }
            }
            if ((l+1<array.length)&&(array[l]>array[l+1])){
                return l+1;
            }else {
                return 0;
            }
        }

    }
}
