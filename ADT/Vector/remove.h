//
// Created by 贺亮 on 08/04/2017.
//

#ifndef VECTOR_REMOVE_H
#define VECTOR_REMOVE_H
template <typename T>
T Vector<T>::remove(Rank r) {
    T e=_elem[r];
    remove(r,r+1);
    return e;
}
#endif //VECTOR_REMOVE_H
