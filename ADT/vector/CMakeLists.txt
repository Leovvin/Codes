cmake_minimum_required(VERSION 3.13)
project(Vector)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(Vector
        bracket.h
        Constructor_by_copying.h
        deduplicate.h
        disordered.h
        expand.h
        find.h
        insert.h
        main.cpp
        remove.h
        removeinterval.h
        search.h
        search_binary.h
        search_fibonaccian.h
        shrink.h
        traverse.h
        uniquify.h
        Vector.h)
