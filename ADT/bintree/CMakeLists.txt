cmake_minimum_required(VERSION 3.13)
project(bintree)

set(CMAKE_CXX_STANDARD 14)

add_executable(bintree main.cpp binnode.h binnode_macro_basic.h bintree.h)