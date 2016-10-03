#include <cstdlib>
#include <math.h>
#include <cstring>
void _redixSort(int a[],int size,int p,int k){
    int* temp=(int*)malloc(sizeof(int)*size);
    int* count=(int*)malloc(sizeof(int)*k);
    int pval=0;
    int index=0;
    for(int i=0;i<p;i++){
        for(int j=0;j<k;j++){
            count[j]=0;
        }
        pval=(int)pow((double)k,(double)i);
        for(int j=0;j<size;j++){
            index=int(a[j]/pval)%k;
            count[index]=count[index]+1;
        }
        for(int j=1;j<k;j++){
            count[j]=count[j]+count[j-1];
        }
        for(int j=size-1;j>=0;j--){
            index=int(a[j]/pval)%k;
            temp[count[index]-1]=a[j];
            count[index]-=1;
        }
        memcpy(a,temp,size* sizeof(int));
    }
    free(count);
    free(temp);
}
void redixSort(int a[],int n){
    _redixSort(a,n,3,10);
}

