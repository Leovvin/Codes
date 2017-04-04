#include <iostream>
#include "Vector.h"
#include "expand.h"
#include "insert.h"

int main() {
    std::cout << "Hello, World!" << std::endl;
    Vector<int> v;
    v.insert(0,1);
    std::cout << v.size() << std::endl;
    return 0;
}