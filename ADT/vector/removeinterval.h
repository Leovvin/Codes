//
// Created by 贺亮 on 04/04/2017.
//

#ifndef VECTOR_REMOVEINTERVAL_H
#define VECTOR_REMOVEINTERVAL_H
template <typename T>
int Vector<T>::remove(Rank lo, Rank hi) {
    if (lo==hi)return 0;
    while (hi<_size){
        _elem[lo++]=_elem[hi++];
    }
    _size=lo;
    shrink();
    return hi-lo;
}
#endif //VECTOR_REMOVEINTERVAL_H
