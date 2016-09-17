void _quickSort(int a[],int l,int r){
    if(l<r){
        int i=l,j=r,x=a[l];
        while(i<j){
            while(i<j && a[j]>=x){
                j--;
            }
            if(i<j){
                a[i++]=a[j];
            }
            while(i<j && a[i]<=x){
                i++;
            }
            if(i<j){
                a[j--]=a[i];
            }
        }
        a[i]=x;
        _quickSort(a,l,i-1);
        _quickSort(a,i+1,r);
    }
}
void quickSort(int a[],int n){
    _quickSort(a,0,n-1);
}

