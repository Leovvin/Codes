#include "swap.h"
/*
 *heapSort
 */
void heapAdjust(int array[],int s,int length){
    int child=2*s+1;
    while(child<length){
        if(child+1<length && array[child]<array[child+1]){
            child++;
        }
        if(array[s]<array[child]){
            swap(array[s],array[child]);
            s=child;
            child=2*s+1;
        }else{
            break;
        }
    }
}
void buildHeap(int array[],int length){
    for(int i=(length-1)/2;i>=0;i--){
        heapAdjust(array,i,length);
    }
}
void heapSort(int array[],int n){
    buildHeap(array,n);
    for(int i=n-1;i>=0;i--){
        swap(array[0],array[i]);
        heapAdjust(array,0,i);
    }
}

