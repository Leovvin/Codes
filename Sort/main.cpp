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
void merge(int array[],int left,int middle,int right){
    int* temp=(int*)malloc(sizeof(int)*10);
    int i=left,j=middle+1,k=left;
    while(i<=middle||j<=right){
        if(array[i]<array[j]){
            temp[k++]=array[i++];
        }else{
            temp[k++]=array[j++];
        }
    }
    if(i>middle){
        while(j<=right){
            temp[k++]=array[j++];
        }
    }else{
        while(i<=middle){
            temp[k++]=array[i++];
        }
    }
    for(int p=left;p<=right;p++){
        array[p]=temp[p];
    }
}
void _mergeSort(int array[],int left,int right){
    if(left<right){
        int middle=(left+right)/2;
        _mergeSort(array,left,middle);
        _mergeSort(array,middle+1,right);
        merge(array,left,middle,right);
    } 
}
void mergeSort(int array[],int n){
    _mergeSort(array,0,n);
}
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
void (*sort)(int array[],int n);
int main(){
//    int* array=creatRandomArray(0,100,10);
//    printArray(array,10);
//    sort=mergeSort;
//    sort(array,10);
//    printArray(array,10);
    int b[]={1,3,5,2,4,6};
    merge(b,0,2,5);
    printArray(b,6);
}
