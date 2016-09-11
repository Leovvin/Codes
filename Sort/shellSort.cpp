#include "swap.h"
/*
 *shellSort
 */
void shellInsertSort(int array[],int n,int dk){
    for(int i=dk;i<n;i++){
        for(int j=i;j>0;j=j-dk){
            if(array[j]<array[j-dk]){
                swap(array[j],array[j-dk]);
            }else{
                break;
            }
        }
    }
}
void shellSort(int array[],int n){
    for(int dk=n/2;dk>=1;dk=dk/2){
        shellInsertSort(array,n,dk);
    }
}

