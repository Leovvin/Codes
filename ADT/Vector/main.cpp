#include <iostream>
#include "Vector.h"
#include "Constructor_by_copying.h"
#include "expand.h"
#include "shrink.h"
#include "insert.h"
#include "removeinterval.h"
#include "traverse.h"

int main() {
    std::cout << "Hello, World!" << std::endl;
    Vector<int> v;
    std::cout << v.size() << std::endl;
    v.insert(0,1);
    v.insert(1,2);
    v.insert(2,2);
    v.insert(3,2);


    return 0;
}