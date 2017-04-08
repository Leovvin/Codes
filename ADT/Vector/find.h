//
// Created by 贺亮 on 08/04/2017.
//

#ifndef VECTOR_FIND_H
#define VECTOR_FIND_H
template <typename T>
Rank Vector<T>::find(T const &e , Rank lo, Rank hi) const {
    while (lo<hi--&&e!=_elem[hi]);
    return hi;
}
#endif //VECTOR_FIND_H
