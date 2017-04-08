//
// Created by 贺亮 on 08/04/2017.
//

#ifndef VECTOR_DISORDERED_H
#define VECTOR_DISORDERED_H
template <typename T>
int Vector<T>::disordered() const {
    int n=0;
    for (int i = 1; i <_size ; ++i) {
        n+=(_elem[i-1]>_elem[i]);
    }
    return n;
}
#endif //VECTOR_DISORDERED_H
