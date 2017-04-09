//
// Created by 贺亮 on 09/04/2017.
//

#ifndef VECTOR_SEARCH_H
#define VECTOR_SEARCH_H
template <typename T>
Rank Vector<T>::search(T const &e, Rank lo, Rank hi) const {
//    return (rand()%2)?binSearch(_elem,e,lo,hi):fibSearch(_elem,e,lo,hi);
    return binSearch(_elem,e,lo,hi);
}

#endif //VECTOR_SEARCH_H
