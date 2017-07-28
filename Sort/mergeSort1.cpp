//
// Created by hel39 on 7/21/17.
//
#include <cstdlib>

void merge1(int array[],int low,int middle,int high){
    int* tmp=(int*)malloc(sizeof(int)*(high-low));
    int i=low,j=middle,k=0;
    while (i<middle&&j<high){
        if(array[i]<array[j]){
            tmp[k++]=array[i++];
        } else{
            tmp[k++]=array[j++];
        }
    }
    if (i<middle){
        while (i<middle){
            tmp[k++]=array[i++];
        }
    } else{
        while (j<high){
            tmp[k++]=array[j++];
        }
    }
    k=0;
    while (k<(high-low) ){
        array[low+k]=tmp[k];
        k++;
    }
    free(tmp);
}
void sort(int array[],int low,int high){
    if(low<high-1){
        int middle=(low+high)/2;
        sort(array,low,middle);
        sort(array,middle,high);
        merge1(array,low,middle,high);
    }
}

void mergeSort1(int array[],int n){
    sort(array,0,n);
}
