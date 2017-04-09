//
// Created by 贺亮 on 09/04/2017.
//

#ifndef VECTOR_SEARCH_BINARY_H
#define VECTOR_SEARCH_BINARY_H
template <typename T>
static Rank binSearch(T* A,T const& e,Rank lo,Rank hi){
    while (lo<hi){
        int mi=(lo+hi)/2;
        if(e<A[mi])hi=mi;
        else if(A[mi]<e)lo=mi+1;
        else return mi;
    }
    return -1;
}
#endif //VECTOR_SEARCH_BINARY_H
