#include <cstdio>
#include <ctime>
#include <cstdlib>
#include "swap.h"
#include "insertSort.h"
#include "mergeSort.h"
#include "heapSort.h"
#include "shellSort.h"
#include "selectionSort.h"
#include "bubbleSort.h"

void printArray(int array[],int n){
    for(int i=0;i<n;i++){
        printf("%d ",array[i]);
    }
    printf("\r\n");
}
int* creatRandomArray(int min,int max,int length){
    int* p;
    p=(int*)malloc(sizeof(int)*length);
    srand(time(NULL));
    for(int i=0;i<length;i++){
        *(p+i)=(rand()%(max-min+1))+min;
    }
    return p;
}
void (*sort)(int array[],int n);
int main(){
    int* array=creatRandomArray(0,100,10);
    printArray(array,10);
    sort=mergeSort;
    sort(array,10);
    printArray(array,10);
}
