#include <cstdlib>

/*
 *mergeSort
 */
void merge(int array[],int left,int middle,int right){
    int* temp=(int*)malloc(sizeof(int)*(right-left));
    int i=left,j=middle,k=0;
    while(i<middle && j<right){
        if(array[i]<array[j]){
            temp[k++]=array[i++];
        }else{
            temp[k++]=array[j++];
        }
    }
    if(i<middle){
	    while(i<middle){
		    temp[k++]=array[i++];
	    }
    }else{
	    while(j<right){
		    temp[k++]=array[j++];
	    }
    }
    for(int p=0;p<right-left;p++){
        array[left+p]=temp[p];
    }
    free(temp);
}
void _mergeSort(int array[],int left,int right){
    if(left<right-1){
        int middle=(left+right)/2;
        _mergeSort(array,left,middle);
        _mergeSort(array,middle,right);
        merge(array,left,middle,right);
    } 
}
void mergeSort(int array[],int n){
    _mergeSort(array,0,n);
}

