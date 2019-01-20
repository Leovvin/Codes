#include <iostream>
#include "binnode.h"

void (*visit) (int data);

void print(int data){
    std::cout << data << std::endl;
}

int main() {
    BinNodePosi(int) node = new BinNode<int>(1);
    BinNodePosi(int) l2l = node->insertAsLC(2);
    BinNodePosi(int) l2r = node->insertAsRC(3);
    l2l->insertAsLC(4);
    l2l->insertAsRC(5);
    l2r->insertAsLC(6);
    l2r->insertAsRC(7);
    visit = print;
    node->travPre(visit);
    std::cout << "--------------------------" << std::endl;
    node->travIn(visit);

    return 0;
}