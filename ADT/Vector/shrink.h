//
// Created by 贺亮 on 04/04/2017.
//

#ifndef VECTOR_SHRINK_H
#define VECTOR_SHRINK_H
template <typename T>
void Vector<T>::shrink() {
    if (_capacity<DEFAULT_CAPACITY<<1)return;
    if (_size<<2>_capacity)return;
    T* oldElem=_elem;
    _elem=new T[_capacity>>=1];
    for (int i = 0; i <_size ; ++i) {
        _elem[i]=oldElem[i];
    }
    delete[] oldElem;
}
#endif //VECTOR_SHRINK_H
