#include <iostream>
#include "binnode.h"

int main() {
    BinNodePosi(int) node = new BinNode<int>(1);
    std::cout << node->size() << std::endl;
    return 0;
}