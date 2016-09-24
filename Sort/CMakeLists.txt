cmake_minimum_required(VERSION 3.6)
project(Sort)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
    bubbleSort.cpp
    bubbleSort.h
    heapSort.cpp
    heapSort.h
    insertSort.cpp
    insertSort.h
    main.cpp
    mergeSort.cpp
    mergeSort.h
    printArray.cpp
    printArray.h
    quickSort.cpp
    quickSort.h
    redixSort.cpp
    redixSort.h
    selectionSort.cpp
    selectionSort.h
    shellSort.cpp
    shellSort.h
    swap.cpp
    swap.h)

add_executable(Sort ${SOURCE_FILES})