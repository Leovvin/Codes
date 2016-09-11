#include "swap.h"
/*
 *selectionSort
 */
void selectionSort(int array[],int n){
    for(int i=0;i<n-1;i++){
        int minIndex=i+1;
        for(int j=i;j<n;j++){
            if(array[minIndex]>array[j]){
                minIndex=j;
            }
        }
        swap(array[i],array[minIndex]);
    }
}

