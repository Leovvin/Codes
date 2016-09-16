#include "swap.h"
/*
 *heapSort
 */
void heapify(int a[],int s,int length){
    int child=2*s+1;
    while(child<length){
        if(child+1<length && a[child]<a[child+1]){
            child++;
        }
        if(a[s]<a[child]){
            swap(a[s],a[child]);
            s=child;
            child=2*s+1;
        }else{
            break;
        }
    }
}
void heapSort(int a[],int n){
    for(int i=(n-1)/2;i>=0;i--){
        heapify(a,i,n);
    }
    for(int i=n-1;i>=1;i--){
        swap(a[0],a[i]);
        heapify(a,0,i-1);
    }
}

