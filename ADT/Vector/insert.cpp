//
// Created by levon on 17-4-4.
//

#ifndef VECTOR_INSERT_H
#define VECTOR_INSERT_H
#include "Vector.h"
template <typename T> //元素类型
Rank Vector<T>::insert(Rank r, T const &e) {
    expand();
    for (int i = _size; i >r ; i--) {
        _elem[i]=_elem[i-1];
    }
    _elem[r]=e;
    _size++;
    return r;
}
#endif //VECTOR_INSERT_H
