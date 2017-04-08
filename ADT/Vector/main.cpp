#include <iostream>
#include "Vector.h"
#include "Constructor_by_copying.h"
#include "expand.h"
#include "shrink.h"
#include "insert.h"
#include "removeinterval.h"
#include "remove.h"
#include "traverse.h"
#include "disordered.h"
#include "bracket.h"

void visit(int & i){
    std::cout << i << std::endl;
}
int main() {
    std::cout << "Hello, World!" << std::endl;
    Vector<int> v;
    std::cout << v.size() << std::endl;
    v.insert(0,1);
    v.insert(1,2);
    v.insert(2,3);
    v.insert(3,4);
    v.remove(0);
    v.traverse(visit);
    std::cout << v[6] << std::endl;
    return 0;
}