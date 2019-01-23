#include <iostream>
#include "binnode.h"
#include "bintree.h"

void (*visit) (int data);

void print(int data){
    std::cout << data << std::endl;
}

int main() {
//    BinNodePosi(int) node = new BinNode<int>(1);
//    BinNodePosi(int) l2l = node->insertAsLC(2);
//    BinNodePosi(int) l2r = node->insertAsRC(3);
//    l2l->insertAsLC(4);
//    l2l->insertAsRC(5);
//    l2r->insertAsLC(6);
//    l2r->insertAsRC(7);
//    visit = print;
//    node->travPre(visit);
//    std::cout << "--------------------------" << std::endl;
//
//    node->travIn(visit);

    BinTree<int> * tree = new BinTree<int>();
    BinNodePosi(int) root = tree->insertAsRoot(1);
    BinNodePosi(int) l2l = tree->insertAsLC(root,2);
    BinNodePosi(int) l3ll = tree->insertAsLC(l2l,3);

    BinTree<int> * tree2 = new BinTree<int>();
    BinNodePosi(int) tree2_root = tree2->insertAsRoot(4);
    BinNodePosi(int) tree2_l2l = tree2->insertAsLC(tree2_root,5);
    BinNodePosi(int) tree2_l3ll = tree2->insertAsLC(tree2_l2l,6);
    
    tree->attachAsRC(root,tree2);

    std::cout <<  tree->size()   << std::endl;
    std::cout <<  root->get_height()   << std::endl;
    return 0;
}
