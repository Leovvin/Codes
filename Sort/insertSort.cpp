#include "swap.h"

/*
 *insertSort
 */
void insertSort(int array[],int n){
    for(int i=1;i<n;i++){
        for(int j=i;j>0;j--){
            if(array[j]<array[j-1]){
                swap(array[j],array[j-1]);
            }else{
                break;
            }
        }
    }
}

