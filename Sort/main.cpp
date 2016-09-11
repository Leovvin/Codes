#include <cstdio>
#include <ctime>
#include <cstdlib>
#include "swap.h"
#include "printArray.h"
#include "insertSort.h"
#include "mergeSort.h"
#include "heapSort.h"
#include "shellSort.h"
#include "selectionSort.h"
#include "bubbleSort.h"

int* creatRandomArray(int min,int max,int length){
    int* p;
    p=(int*)malloc(sizeof(int)*length);
    srand(time(NULL));
    for(int i=0;i<length;i++){
        *(p+i)=(rand()%(max-min+1))+min;
    }
    return p;
}
int* buildTempArray(int min,int max,int length){
    int* p;
    p=(int*)malloc(sizeof(int)*length);
    p[0]=1;
    p[1]=3;
    p[2]=5;
    p[3]=7;
    p[4]=9;
    p[5]=2;
    p[6]=4;
    p[7]=6;
    p[8]=8;
    p[9]=10;
    return p;
}
void (*sort)(int array[],int n);
int* (*buildArray)(int min,int max,int length);
int main(){
    buildArray=creatRandomArray;
    int* array=buildArray(0,100,10);
    printArray(array,10);
    sort=mergeSort;
    sort(array,10);
    printArray(array,10);
}
