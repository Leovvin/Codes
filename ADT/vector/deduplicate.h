//
// Created by 贺亮 on 08/04/2017.
//

#ifndef VECTOR_DEDUPLICATE_H
#define VECTOR_DEDUPLICATE_H
template <typename T>
int Vector<T>::deduplicate() {
    int oldSize=_size;
    Rank i=1;
    while (i<_size){
        find(_elem[i],0,i)<0?i++:remove(i);
    }
    return oldSize-_size;
}
#endif //VECTOR_DEDUPLICATE_H
