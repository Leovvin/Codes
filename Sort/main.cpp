#include <cstdio>
#include <ctime>
#include <cstdlib>

void swap(int& a,int& b){
    int temp=a;
    a=b;
    b=temp;
}
void mergeSort(int array[],int n){
}
void heapAdjust (int array[],int){
}		
void heapSort(int array[],int n){
}
void shellInsertSort (int array[],int n,int dk){
    for ( int i=dk;i<n ;++i ) {
        for (int j=i;j>0 ;j-=dk ) {
            if ( array[j]<array[j-dk] ){
                swap(array[j],array[j-dk]);
            }else{
                break;
            }
        }
    }
}	
void shellSort(int array[],int n){
    for ( int dk=n/2;dk>=1 ;dk=dk/2 ) {
        shellInsertSort(array,n,dk);
    }
}
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
void bubbleSort(int array[],int n){
    for(int i=0;i<n-1;i++){
        for(int j=i+1;j<n;j++){
            if(array[i]>array[j]){
                swap(array[i],array[j]);
            }
        }
    }
}
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
int main(){
    int* array=creatRandomArray(0,100,10);
    printArray(array,10);
    shellSort(array,10);
    printArray(array,10);
}
