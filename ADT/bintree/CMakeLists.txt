cmake_minimum_required(VERSION 3.13)
project(bintree)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(bintree
        binnode.h
        binnode_macro_basic.h
        bintree.h
        main.cpp
        release.h)
