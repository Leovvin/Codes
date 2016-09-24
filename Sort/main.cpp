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
#include "quickSort.h"
#include "redixSort.h"

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
int* (*buildArray)(int min,int max,int length);
int main(){
    buildArray=creatRandomArray;
    int* array=buildArray(0,100,10);
    printArray(array,10);
    sort=mergeSort;
    sort(array,10);
    printArray(array,10);
}
