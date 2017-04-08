//
// Created by 贺亮 on 08/04/2017.
//

#ifndef VECTOR_BRACKET_H
#define VECTOR_BRACKET_H
template <typename T>
T& Vector<T>::operator[](Rank r) const {
    return _elem[r];
}
#endif //VECTOR_BRACKET_H
