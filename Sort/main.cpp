#include <cstdio>
#include <ctime>
#include <cstdlib>
void swap(int& a,int& b){
    int temp=a;
    a=b;
    b=temp;
}
/*
 *mergeSort
 */
void mergeSort(int array[],int n){
}
/*
 *heapSort
 */
void heapAdjust(int array[],int s,int length){
    int child=2*s+1;
    int tmp=array[s];
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
/*
 *bubbleSort
 */
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
