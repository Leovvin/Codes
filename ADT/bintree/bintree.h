//
// Created by Leo on 2019-01-20.
//

#ifndef BINTREE_BINTREE_H
#define BINTREE_BINTREE_H
#pragma once
#include "binnode.h"

template <typename T> class BinTree{
protected:
   int _size;
   BinNodePosi(T) _root;
   virtual int updateHeight(BinNodePosi(T) x);
   void updateHeightAbove(BinNodePosi(T) x);

public:
    BinTree():_size(0),_root(NULL){}
    ~BinTree(){
        if (0<_size){
            remove(_root);
        }
    }
    int size() const { return _size;}
    bool empty() const { return !_root;}
    BinNodePosi(T) root() const { return _root;}

    BinNodePosi(T) insertAsRoot(T const& e);
    BinNodePosi(T) insertAsLC(BinNodePosi(T) x,T const& e);
    BinNodePosi(T) insertAsRC(BinNodePosi(T) x,T const& e);
    BinNodePosi(T) attachAsLC(BinNodePosi(T) x,BinTree<T>* &t);
    BinNodePosi(T) attacjAsRC(BinNodePosi(T) x,BinTree<T>* &t);
    int remove(BinNodePosi(T) x);
    BinTree<T>* secede(BinNodePosi(T) x);
    template <typename VST> void travLevel(VST& vst);
    template <typename VST> void travPre(VST& vst);
    template <typename VST> void travIn(VST& vst);
    template <typename VST> void travPost(VST& vst);
    bool operator< (BinTree<T> const& t){
        return _root && t._root && (_root < t._root);
    }
    bool operator== (BinTree<T> const& t){
        return _root && t._root && (_root == t._root);
    }
};

template <typename T> BinNodePosi(T) BinTree<T>::insertAsRoot(const T &e) {
    _size = 1;
    _root = new BinNode<T>(e);
}

template <typename T> BinNodePosi(T) BinTree<T>::insertAsRC(BinNode<T> *x, const T &e) {
    _size++;
    x->insertAsRC(e);
    updateHeightAbove(x);
    return x->rc;
}

template <typename T> BinNodePosi(T) BinTree<T>::insertAsLC(BinNode<T> *x, const T &e) {
    _size++;
    x->insertAsLC(e);
    updateHeightAbove(x);
    return x->rc;
}

template <typename T> BinNodePosi(T) BinTree<T>::attachAsLC(BinNode<T> *x, BinTree<T> *&t) {
    
}
template <typename T> void BinTree<T>::updateHeightAbove(BinNode<T> *x) {

}
#endif //BINTREE_BINTREE_H
