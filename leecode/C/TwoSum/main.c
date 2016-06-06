/*
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
#include <stdio.h>
#include <stdlib.h>
int* twoSum(int* nums, unsigned int numsize,int target);
int main(){
    int nums[]={2,7,11,15};
    int* result=twoSum(nums,4,9);
    printf("%d,%d \n",result[0],result[1]);
    free(result);
}
int* twoSum(int* nums,unsigned int numsize,int target){
    int* result=(int*)malloc(sizeof(int)*2);
    for(unsigned int i=0;i<numsize-1;i++){
        for(unsigned int j=i+1;j<numsize;j++){
            if(nums[i]+nums[j]==target){
                result[0]=nums[i];
                result[1]=nums[j];
                return result;
            }
        } 
    }
}
