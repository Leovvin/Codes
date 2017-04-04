//
// Created by levon on 17-4-4.
//

#ifndef VECTOR_EXPAND_H
#define VECTOR_EXPAND_H
#include "Vector.h"
template <typename T> //元素类型
void Vector<T>::expand() {
    if (_size<_capacity)return;
    if (_capacity<DEFAULT_CAPACITY)_capacity=DEFAULT_CAPACITY;
    T* oldEle=_elem;
    _elem=new T[_capacity<<=1];
    for (int i=0;i<_size;i++){
        _elem[i]=oldEle[i];
    }
    delete [] oldEle;
}
#endif //VECTOR_EXPAND_H
