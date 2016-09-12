#include <cstdlib>

/*
 *mergeSort
 */
void merge(int array[],int left,int middle,int right){
    int* temp=(int*)malloc(sizeof(int)*(right-left+1));
    int i=left,j=middle+1,k=left;
    while(i<=middle && j<=right){
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
    _mergeSort(array,0,n-1);
}

