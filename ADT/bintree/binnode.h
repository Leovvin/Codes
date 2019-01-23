//
// Created by Leo on 2019-01-13.
//
#ifndef BINTREE_BINNODE_H
#define BINTREE_BINNODE_H

#include "binnode_macro_basic.h"
#include <iostream>
#include <queue>
#include <stack>

#define BinNodePosi(T) BinNode<T> *
#define stature(p) ((p) ? (p)->height : -1)
typedef enum {RB_RED, RB_BLACK} RBColor;

template <typename T> struct BinNode{

    T data;
    BinNodePosi(T) parent; BinNodePosi(T) lc; BinNodePosi(T) rc;
    int height;
    int npl;//null path length
    RBColor color;

    BinNode():
            parent( NULL ), lc( NULL ), rc( NULL ), height( 0 ), npl( 1 ),color( RB_RED ) {};
    BinNode(T e,BinNodePosi(T) p = NULL, BinNodePosi(T) lc = NULL, BinNodePosi(T) rc = NULL,
            int h = 0,int l = 1,RBColor color = RB_RED):
            data(e),parent(p),lc(lc),rc(rc),height(h),npl(l),color(color){};

    int size();
    int get_height();
    BinNodePosi(T) insertAsLC(T const& e);
    BinNodePosi(T) insertAsRC(T const& e);
    BinNodePosi(T) succ();
    template <typename VST> void travLevel( VST& vst);
    template <typename VST> void travPre( VST& vst);
    template <typename VST> void travIn( VST& vst);
    template <typename VST> void travPost( VST& vst);

    bool operator< ( BinNode const& bn){ return data < bn.data;}
    bool operator== (BinNode const& bn){ return data == bn.data;}

};

template <typename T> int BinNode<T>::size(){
    int s = 1;
    if(lc) s += lc->size();
    if(rc) s += rc->size();
    return s;
}

template <typename T> int BinNode<T>::get_height(){
    return height;
}

template <typename T> BinNodePosi(T) BinNode<T>::insertAsLC(const T &e) {
    BinNodePosi(T) node = new BinNode(e,this);
    lc = node;
    return node;
}

template <typename T> BinNodePosi(T) BinNode<T>::insertAsRC(const T &e) {
    return rc = new BinNode(e,this);
}

template <typename T> template <typename VST> void BinNode<T>::travLevel(VST& vst){
    std::queue<BinNodePosi(T)> q;
    q.push(this);
    while (!q.empty()){
        BinNodePosi(T) n = q.front();
        q.pop();
        vst(n->data);

        if (HasLChild(*n)) q.push(n->lc);
        if (HasRChild(*n)) q.push(n->rc);
    }
}

template <typename T> template <typename VST> void BinNode<T>::travPre(VST &vst) {
    std::stack<BinNodePosi(T)> s;
    s.push(this);
    while (!s.empty()){
        BinNodePosi(T) n = s.top();s.pop();
        vst(n->data);
        if(HasRChild(*n)) s.push(n->rc);
        if(HasLChild(*n)) s.push(n->lc);
    }
}

template <typename T,typename VST> void travIn_r(BinNodePosi(T) node, VST &vst){
    if(!node) return;
    travIn_r(node->lc,vst);
    vst(node->data);
    travIn_r(node->rc,vst);
}

template <typename T> void goAlongLeftBranch(BinNodePosi(T) node,std::stack<BinNodePosi(T)>& s){
    s.push(node);
    while (HasLChild(*node)){
        node = node->lc;
        s.push(node);
    }
}
template <typename T> template <typename VST> void BinNode<T>::travIn(VST &vst) {
    std::stack<BinNodePosi(T)> s;
    goAlongLeftBranch(this,s);
    while (!s.empty()){
        BinNodePosi(T) node = s.top();s.pop();
        vst(node->data);
        if (HasRChild(*node)){
            goAlongLeftBranch(node->rc,s);
        }
    }
}


#endif //BINTREE_BINNODE_H
