//
// Created by 贺亮 on 04/04/2017.
//

#ifndef VECTOR_TRAVERSE_H
#define VECTOR_TRAVERSE_H
template <typename T>
void Vector<T>::traverse(void (*visit)(T &)) {
    for (int i = 0; i <_size ; ++i) {
        visit(_elem[i]);
    }
}
template <typename T> template <typename VST>
void Vector<T>::traverse(VST & visit) {
    for (int i = 0; i < _size; ++i) {
        visit(_elem[i]);
    }
}
#endif //VECTOR_TRAVERSE_H
