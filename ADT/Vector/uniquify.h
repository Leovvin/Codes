//
// Created by 贺亮 on 08/04/2017.
//

#ifndef VECTOR_UNIQUIFY_H
#define VECTOR_UNIQUIFY_H
template <typename T>
int Vector<T>::uniquify() {
    int i=0,j=0;
    while (++j<_size)
        if(_elem[j]!=_elem[i])_elem[++i]=_elem[j];
    _size=++i;
    shrink();
    return j-i;
}
#endif //VECTOR_UNIQUIFY_H
